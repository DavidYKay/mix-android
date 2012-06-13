package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.exception.MixedByteException;

public abstract class MIXByte {
  public abstract int value();
  public abstract void set(int value) throws ByteSizeException;

  abstract int getValueCount();

  public static int valueOfArray(MIXByte[] bytes) throws MixedByteException {
    return valueOfArray(bytes, bytes.length - 1);
  }

  private static int valueOfArray(MIXByte[] bytes, int index) {
    if (index < 0) {
      return 0;
      //return bytes[0].value();
    } else {
      int base = bytes[0].getValueCount();
      int pow = (bytes.length - 1) - index;

      int columnValue = (int) Math.pow(base, pow);
      int columnDigit = bytes[index].value();
      int currentByteValue = columnDigit * columnValue;

      return currentByteValue + valueOfArray(bytes, --index);
    }
  }
}
