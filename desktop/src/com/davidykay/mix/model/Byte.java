package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.exception.MixedByteException;

public abstract class Byte {
  public abstract int value();
  public abstract void set(int value) throws ByteSizeException;  
  abstract int getValueCount();

  public static int valueOfArray(Byte[] bytes) throws MixedByteException {
    return valueOfArray(bytes, bytes.length - 1);
  }

  private static int valueOfArray(Byte[] bytes, int index) {
    if (index == 0) {
      return bytes[0].value();
    } else {
      int base = bytes[0].getValueCount();
      int currentByteValue = (int) (bytes[index].value() * (Math.pow(base, index)));
      return currentByteValue + valueOfArray(bytes, --index);
    }
  }
}
