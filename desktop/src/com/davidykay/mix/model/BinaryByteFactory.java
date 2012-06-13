package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;

public class BinaryByteFactory implements ByteFactory {
  @Override
  public MIXByte create(int i) throws ByteSizeException {
    MIXByte bite = new BinaryByte();
    bite.set(i);
    return bite;
  }
}