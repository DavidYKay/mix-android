package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.exception.InvalidIndexException;
import com.google.inject.Inject;

public class Index implements Byteable {

  public class IndexFactory {

    private ByteFactory mByteFactory;

    @Inject
    public IndexFactory(ByteFactory byteFactory) {
      mByteFactory = byteFactory;
    }

    public Index make(int value) throws ByteSizeException {
      return new Index(
          mByteFactory.make(value)
          );
    }
  }

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

}
