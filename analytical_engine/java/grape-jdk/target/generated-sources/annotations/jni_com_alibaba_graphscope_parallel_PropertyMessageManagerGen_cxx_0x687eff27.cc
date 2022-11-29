#include <jni.h>
#include <new>
#include "core/parallel/property_message_manager.h"
#include "vineyard/graph/fragment/arrow_fragment.h"
#include "core/java/java_messages.h"
#include "core/java/type_alias.h"
#include "cstdint"
#include "core/parallel/property_message_manager.h"
#include "vineyard/graph/fragment/arrow_fragment.h"
#include "core/java/java_messages.h"
#include "core/java/type_alias.h"
#include "cstdint"

#ifdef __cplusplus
extern "C" {
#endif

// Common Stubs

JNIEXPORT
jint JNICALL Java_com_alibaba_graphscope_parallel_PropertyMessageManagerGen_1cxx_10x687eff27__1elementSize_00024_00024_00024(JNIEnv*, jclass) {
    return (jint)sizeof(gs::PropertyMessageManager);
}

JNIEXPORT
void JNICALL Java_com_alibaba_graphscope_parallel_PropertyMessageManagerGen_1cxx_10x687eff27_nativeFinishARound(JNIEnv*, jclass, jlong ptr) {
	reinterpret_cast<gs::PropertyMessageManager*>(ptr)->FinishARound();
}

JNIEXPORT
void JNICALL Java_com_alibaba_graphscope_parallel_PropertyMessageManagerGen_1cxx_10x687eff27_nativeForceContinue(JNIEnv*, jclass, jlong ptr) {
	reinterpret_cast<gs::PropertyMessageManager*>(ptr)->ForceContinue();
}

JNIEXPORT
jlong JNICALL Java_com_alibaba_graphscope_parallel_PropertyMessageManagerGen_1cxx_10x687eff27_nativeGetMsgSize(JNIEnv*, jclass, jlong ptr) {
	return (jlong)(reinterpret_cast<gs::PropertyMessageManager*>(ptr)->GetMsgSize());
}

JNIEXPORT
void JNICALL Java_com_alibaba_graphscope_parallel_PropertyMessageManagerGen_1cxx_10x687eff27_nativeStart(JNIEnv*, jclass, jlong ptr) {
	reinterpret_cast<gs::PropertyMessageManager*>(ptr)->Start();
}

JNIEXPORT
void JNICALL Java_com_alibaba_graphscope_parallel_PropertyMessageManagerGen_1cxx_10x687eff27_nativeStartARound(JNIEnv*, jclass, jlong ptr) {
	reinterpret_cast<gs::PropertyMessageManager*>(ptr)->StartARound();
}

JNIEXPORT
jboolean JNICALL Java_com_alibaba_graphscope_parallel_PropertyMessageManagerGen_1cxx_10x687eff27_nativeToTerminate(JNIEnv*, jclass, jlong ptr) {
	return (reinterpret_cast<gs::PropertyMessageManager*>(ptr)->ToTerminate()) ? JNI_TRUE : JNI_FALSE;
}

#ifdef __cplusplus
}
#endif
