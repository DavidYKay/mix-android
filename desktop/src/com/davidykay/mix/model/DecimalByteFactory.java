package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;

public class DecimalByteFactory implements ByteFactory {

  @Override
  public Byte create(int i) throws ByteSizeException {
    Byte bite = new DecimalByte();
    bite.set(i);
    return bite;
  }

}
