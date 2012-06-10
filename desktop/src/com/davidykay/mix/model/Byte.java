package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.exception.MixedByteException;

public abstract class Byte {
  public abstract int value();
  public abstract void set(int value) throws ByteSizeException;  
  abstract int getValueCount();

  public static int getValueOfArray(Byte[] bytes) throws MixedByteException {
    return getValueOfArray(bytes, bytes.length - 1);
  }

  private static int getValueOfArray(Byte[] bytes, int index) {
    if (index == 0) {
      return bytes[0].value();
    } else {
      return getValueOfArray(bytes, --index);
    }
  }
}
