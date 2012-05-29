package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;

public class BinaryByteFactory implements ByteFactory {

  @Override
  public Byte create(int i) throws ByteSizeException {
    Byte bite = new BinaryByte();
    bite.set(i);
    return bite;
  }

}
