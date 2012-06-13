package com.davidykay.mix.model;

import com.davidykay.mix.exception.InvalidIndexException;

public class Index implements Byteable {

  private static final int MIN_INDEX = 0;
  private static final int MAX_INDEX = 6;

  //private int mValue;
  private MIXByte mByte;

  public Index(MIXByte mixByte) {
    if (mixByte.value() < MIN_INDEX) {
      throw new InvalidIndexException("Index cannot be less than " + MIN_INDEX);
    }
    if (mixByte.value() > MAX_INDEX) {
      throw new InvalidIndexException("Index cannot be more than " + MAX_INDEX);
    }

    mByte = mixByte;
  }

  public int value() {
    return mByte.value();
  }

  public MIXByte toByte() {
    return mByte;
  }

  public String toString() {
    return String.valueOf(mByte.value());
  }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Index)) {
      return false;
    }
    Index other = (Index) o;
    if (other.value() != this.value()) {
      return false;
    }
    return true;
  }

}
