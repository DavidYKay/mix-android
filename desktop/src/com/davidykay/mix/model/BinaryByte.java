package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;

public class BinaryByte extends MIXByte {

  public static final int MAX_SIZE = 63;

  private int mValue;

  public int value() {
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
    if (!(o instanceof MIXByte)) {
      return false;
    }
    MIXByte other = (MIXByte) o;
    if (other.value() != this.value()) {
      return false;
    }
    return true;
  }

  public String toString() {
    return String.format("%d", mValue);
  }

  @Override
  int getValueCount() {
    return MAX_SIZE + 1;
  }

}
