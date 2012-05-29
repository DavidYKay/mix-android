package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;

public interface ByteFactory {
  public Byte create(int i) throws ByteSizeException;
}
