package com.alibaba.graphscope.stdcxx;

import com.alibaba.fastffi.CXXOperator;
import com.alibaba.fastffi.FFIForeignType;
import com.alibaba.fastffi.FFIPointerImpl;
import com.alibaba.fastffi.FFISynthetic;
import com.alibaba.fastffi.FFITypeFactory;
import java.lang.Object;
import java.lang.String;
import java.lang.UnsatisfiedLinkError;

@FFIForeignType(
    value = "char",
    factory = CCharPointer_cxx_0x2e9356Factory.class
)
@FFISynthetic("com.alibaba.graphscope.stdcxx.CCharPointer")
public class CCharPointer_cxx_0x2e9356 extends FFIPointerImpl implements CCharPointer {
  public static final int SIZE;

  public static final int HASH_SHIFT;

  static {
    try {
      System.loadLibrary("grape-jni");
    } catch (UnsatisfiedLinkError e) {
      System.load(FFITypeFactory.findNativeLibrary(CCharPointer_cxx_0x2e9356.class, "grape-jni"));
    }
  }
  static {
    SIZE = _elementSize$$$();
    assert SIZE > 0;
    HASH_SHIFT = 31 - Integer.numberOfLeadingZeros(1 + SIZE);
    assert HASH_SHIFT > 0;
  }

  public CCharPointer_cxx_0x2e9356(final long address) {
    super(address);
  }

  private static final native int _elementSize$$$();

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CCharPointer_cxx_0x2e9356 that = (CCharPointer_cxx_0x2e9356) o;
    return this.address == that.address;
  }

  public int hashCode() {
    return (int) (address >> HASH_SHIFT);
  }

  public String toString() {
    return getClass().getName() + "@" + Long.toHexString(address);
  }

  public CCharPointer add(long arg0) {
    return new CCharPointer_cxx_0x2e9356(this.address + arg0);
  }

  public void addV(long arg0) {
    this.address += arg0;
  }

  public long elementSize() {
    return SIZE;
  }

  @CXXOperator("*&")
  public byte get() {
    return nativeGet(address);
  }

  @CXXOperator("*&")
  public static native byte nativeGet(long ptr);

  public CCharPointer moveTo(long arg0) {
    return new CCharPointer_cxx_0x2e9356(arg0);
  }

  public void moveToV(long arg0) {
    this.address = arg0;
  }

  public void setAddress(long arg0) {
    this.address = arg0;
  }

  public static native long nativeCreateFactory0();
}
