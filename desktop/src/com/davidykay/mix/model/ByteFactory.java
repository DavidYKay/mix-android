package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;

public interface ByteFactory {
  public MIXByte create(int i) throws ByteSizeException;
}
