package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;

public class DecimalByteFactory implements ByteFactory {

  @Override
  public MIXByte make(int i) throws ByteSizeException {
    MIXByte bite = new DecimalByte();
    bite.set(i);
    return bite;
  }

  @Override
  public MIXByte[] makeArrayWithValue(int value) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public MIXByte[] makeArrayWithIntArray(int[] values) {
    // TODO Auto-generated method stub
    return null;
  }

}
