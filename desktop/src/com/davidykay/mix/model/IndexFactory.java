package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;
import com.google.inject.Inject;

public class IndexFactory {

  private ByteFactory mByteFactory;

  @Inject
  public IndexFactory(ByteFactory byteFactory) {
    mByteFactory = byteFactory;
  }

  public Index make() throws ByteSizeException {
    return make(0);
  }

  public Index make(int value) throws ByteSizeException {
    return new Index(
        mByteFactory.make(value)
        );
  }
}
