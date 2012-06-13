package com.davidykay.mix.model;

import com.davidykay.mix.exception.InvalidIndexException;

public class Index implements Byteable {
  private static final int MIN_INDEX = 0;
  private static final int MAX_INDEX = 6;

  private int mValue;

  public Index(int i) {
    if (i < MIN_INDEX) {
      throw new InvalidIndexException("Index cannot be less than " + MIN_INDEX);
    }
    if (i > MAX_INDEX) {
      throw new InvalidIndexException("Index cannot be more than " + MAX_INDEX);
    }

    mValue = i;
  }

  public MIXByte toByte() {
    return null;
  }

}
