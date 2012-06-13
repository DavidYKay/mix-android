package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;

public class DecimalByteFactory implements ByteFactory {

  @Override
  public MIXByte create(int i) throws ByteSizeException {
    MIXByte bite = new DecimalByte();
    bite.set(i);
    return bite;
  }

}
