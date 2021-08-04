//
//! Copyright 2020 Alibaba Group Holding Limited.
//!
//! Licensed under the Apache License, Version 2.0 (the "License");
//! you may not use this file except in compliance with the License.
//! You may obtain a copy of the License at
//!
//! http://www.apache.org/licenses/LICENSE-2.0
//!
//! Unless required by applicable law or agreed to in writing, software
//! distributed under the License is distributed on an "AS IS" BASIS,
//! WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//! See the License for the specific language governing permissions and
//! limitations under the License.

use super::FlatMapFuncGen;
use crate::generated::gremlin as pb;
use crate::process::traversal::traverser::{Traverser, TraverserSplitIter};
use crate::structure::{Direction, Element, GraphElement, QueryParams, Statement, ID};
use crate::{str_to_dyn_error, DynIter, DynResult, FromPb};
use bit_set::BitSet;
use pegasus::api::function::FlatMapFunction;
use std::sync::Arc;
use std::time::Instant;
use std::cell::Cell;

pub struct FlatMapStatement<E: Into<GraphElement>> {
    tags: Arc<BitSet>,
    stmt: Box<dyn Statement<ID, E>>,
    timer: Cell<u128>,
}

impl<E: Into<GraphElement> + 'static> FlatMapFunction<Traverser, Traverser>
    for FlatMapStatement<E>
{
    type Target = DynIter<Traverser>;

    fn exec(&self, input: Traverser) -> DynResult<DynIter<Traverser>> {
        if let Some(e) = input.get_element() {
            let id = e.id();
            let begin = Instant::now();
            let iter = self.stmt.exec(id)?;
            let end = Instant::now();
            let latency = end.duration_since(begin).as_micros();
            let mut total_time = self.timer.get();
            total_time += latency;
            self.timer.set(total_time);
            Ok(Box::new(TraverserSplitIter::new(input, &self.tags, iter)))
        } else {
            Err(str_to_dyn_error("invalid input for vertex/edge step"))
        }
    }
}

impl<E: Into<GraphElement>> Drop for FlatMapStatement<E>{
    fn drop(&mut self) {
        info!("Store EXEC Time: {:?} ms", self.timer.get() as f64 / 1000.0);
    }
}

/// out(), in(), both(), outE(), inE(), bothE()
pub struct VertexStep {
    pub step: pb::VertexStep,
    pub tags: BitSet,
}

impl FlatMapFuncGen for VertexStep {
    fn gen_flat_map(
        self,
    ) -> DynResult<Box<dyn FlatMapFunction<Traverser, Traverser, Target = DynIter<Traverser>>>>
    {
        let step = self.step;
        let direction_pb = unsafe { std::mem::transmute(step.direction) };
        let direction = Direction::from_pb(direction_pb)?;
        let graph = crate::get_graph().ok_or(str_to_dyn_error("Graph is None"))?;
        if step.return_type == 0 {
            let params = QueryParams::from_pb(step.query_params)?;
            let stmt = graph.prepare_explore_vertex(direction, &params)?;
            Ok(Box::new(FlatMapStatement { tags: Arc::new(self.tags), stmt, timer: Cell::new(0) }))
        } else if step.return_type == 1 {
            let params = QueryParams::from_pb(step.query_params)?;
            let stmt = graph.prepare_explore_edge(direction, &params)?;
            Ok(Box::new(FlatMapStatement { tags: Arc::new(self.tags), stmt, timer: Cell::new(0) }))
        } else {
            Err(str_to_dyn_error("Wrong return type in VertexStep"))
        }
    }
}
