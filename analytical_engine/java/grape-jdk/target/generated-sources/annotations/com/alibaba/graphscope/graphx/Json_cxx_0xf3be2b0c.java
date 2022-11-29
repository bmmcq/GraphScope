package com.alibaba.graphscope.graphx;

import com.alibaba.fastffi.CXXValue;
import com.alibaba.fastffi.FFIByteString;
import com.alibaba.fastffi.FFIForeignType;
import com.alibaba.fastffi.FFINameAlias;
import com.alibaba.fastffi.FFIPointerImpl;
import com.alibaba.fastffi.FFISynthetic;
import com.alibaba.fastffi.FFITypeFactory;
import java.lang.Object;
import java.lang.String;
import java.lang.UnsatisfiedLinkError;

@FFIForeignType("vineyard::json")
@FFISynthetic("com.alibaba.graphscope.graphx.Json")
public class Json_cxx_0xf3be2b0c extends FFIPointerImpl implements Json {
  public static final int SIZE;

  public static final int HASH_SHIFT;

  static {
    try {
      System.loadLibrary("grape-jni");
    } catch (UnsatisfiedLinkError e) {
      System.load(FFITypeFactory.findNativeLibrary(Json_cxx_0xf3be2b0c.class, "grape-jni"));
    }
  }
  static {
    SIZE = _elementSize$$$();
    assert SIZE > 0;
    HASH_SHIFT = 31 - Integer.numberOfLeadingZeros(1 + SIZE);
    assert HASH_SHIFT > 0;
  }

  public Json_cxx_0xf3be2b0c(final long address) {
    super(address);
  }

  private static final native int _elementSize$$$();

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Json_cxx_0xf3be2b0c that = (Json_cxx_0xf3be2b0c) o;
    return this.address == that.address;
  }

  public int hashCode() {
    return (int) (address >> HASH_SHIFT);
  }

  public String toString() {
    return getClass().getName() + "@" + Long.toHexString(address);
  }

  @FFINameAlias("dump")
  @CXXValue
  public FFIByteString dump() {
    long ret$ = nativeDump(address, com.alibaba.fastffi.CXXValueScope.allocate(com.alibaba.fastffi.impl.CXXStdString_cxx_0xcec1e274.SIZE)); return (new com.alibaba.fastffi.impl.CXXStdString_cxx_0xcec1e274(ret$));
  }

  @FFINameAlias("dump")
  @CXXValue
  public static native long nativeDump(long ptr, long rv_base);
}
