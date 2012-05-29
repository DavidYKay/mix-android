package com.davidykay.mix;

import com.davidykay.mix.exception.ByteSizeException;

public class BinaryByte implements Byte {
  
  public static final int MAX_SIZE = 63;

  private int mValue;

  public int get() {
    return mValue;
  }

  public void set(int value) throws ByteSizeException {
    if (value > MAX_SIZE) {
      throw new ByteSizeException(String.format("Value (%d) exceeded byte size of the system (%d)",
                                                value,
                                                MAX_SIZE));
    }
    mValue = value;
  }

}
