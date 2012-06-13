package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;

public interface ByteFactory {
  public MIXByte make(int i) throws ByteSizeException;
  public MIXByte[] makeArrayWithValue(int value);
  public MIXByte[] makeArrayWithIntArray(int[] values) throws ByteSizeException;
}
