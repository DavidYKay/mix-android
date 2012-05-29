package com.davidykay.mix.model;

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
  
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Byte)) {
      return false;
    }
    Byte other = (Byte) o;
    if (other.get() != this.get()) {
      return false;
    }
    return true;
  }
  
  public String toString() {
    return String.format("%d", mValue);
  }

}
