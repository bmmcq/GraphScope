package com.alibaba.graphscope.stdcxx;

import com.alibaba.fastffi.CXXOperator;
import com.alibaba.fastffi.CXXReference;
import com.alibaba.fastffi.CXXValue;
import com.alibaba.fastffi.FFIForeignType;
import com.alibaba.fastffi.FFIPointerImpl;
import com.alibaba.fastffi.FFISynthetic;
import com.alibaba.fastffi.FFITypeFactory;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.UnsatisfiedLinkError;

@FFIForeignType(
    value = "std::vector<int32_t>",
    factory = StdVector_cxx_0xe1443cf1Factory.class
)
@FFISynthetic("com.alibaba.graphscope.stdcxx.StdVector")
public class StdVector_cxx_0xe1443cf1 extends FFIPointerImpl implements StdVector<Integer> {
  public static final int SIZE;

  public static final int HASH_SHIFT;

  static {
    try {
      System.loadLibrary("grape-jni");
    } catch (UnsatisfiedLinkError e) {
      System.load(FFITypeFactory.findNativeLibrary(StdVector_cxx_0xe1443cf1.class, "grape-jni"));
    }
  }
  static {
    SIZE = _elementSize$$$();
    assert SIZE > 0;
    HASH_SHIFT = 31 - Integer.numberOfLeadingZeros(1 + SIZE);
    assert HASH_SHIFT > 0;
  }

  public StdVector_cxx_0xe1443cf1(final long address) {
    super(address);
  }

  private static final native int _elementSize$$$();

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StdVector_cxx_0xe1443cf1 that = (StdVector_cxx_0xe1443cf1) o;
    return this.address == that.address;
  }

  public int hashCode() {
    return (int) (address >> HASH_SHIFT);
  }

  public String toString() {
    return getClass().getName() + "@" + Long.toHexString(address);
  }

  public long capacity() {
    return nativeCapacity(address);
  }

  public static native long nativeCapacity(long ptr);

  public void clear() {
    nativeClear(address);
  }

  public static native void nativeClear(long ptr);

  public long data() {
    return nativeData(address);
  }

  public static native long nativeData(long ptr);

  @CXXOperator("delete")
  public void delete() {
    nativeDelete(address);
  }

  @CXXOperator("delete")
  public static native void nativeDelete(long ptr);

  @CXXOperator("[]")
  @CXXReference
  public Integer get(long index) {
    return new java.lang.Integer(nativeGet(address, index));
  }

  @CXXOperator("[]")
  @CXXReference
  public static native int nativeGet(long ptr, long index0);

  public void push_back(@CXXValue Integer e) {
    nativePush_back(address, e);
  }

  public static native void nativePush_back(long ptr, int e0);

  public void reserve(long size) {
    nativeReserve(address, size);
  }

  public static native void nativeReserve(long ptr, long size0);

  public void resize(long size) {
    nativeResize(address, size);
  }

  public static native void nativeResize(long ptr, long size0);

  @CXXOperator("[]")
  public void set(long index, @CXXReference Integer value) {
    nativeSet(address, index, value);
  }

  @CXXOperator("[]")
  public static native void nativeSet(long ptr, long index0, int value1);

  public void setAddress(long arg0) {
    this.address = arg0;
  }

  public long size() {
    return nativeSize(address);
  }

  public static native long nativeSize(long ptr);

  public static native long nativeCreateFactory0();
}
