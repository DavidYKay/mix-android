package com.davidykay.mix;

import com.davidykay.mix.exception.ByteSizeException;

public interface Byte {
  public int get();
  public void set(int value) throws ByteSizeException;
}
