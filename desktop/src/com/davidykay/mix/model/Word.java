package com.davidykay.mix.model;

import com.davidykay.mix.exception.InvalidWordSizeException;
import com.google.inject.Inject;

public class Word {
  
  public static final int WORD_SIZE = 5;

  //public Sign sign    = new Sign();
  //public Byte[] bytes = new Byte[5];
  public Sign sign    ;
  public Byte[] bytes ;

  @Inject
  public Word(Sign sign, Byte[] bytes) throws InvalidWordSizeException {
    this.sign = sign;
    if (bytes.length > WORD_SIZE) {
      throw new InvalidWordSizeException(String.format("Value (%d) exceeded word size of the system (%d)",
                                                bytes.length,
                                                WORD_SIZE));
    }
    this.bytes = bytes;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Byte bite : bytes) {
      sb.append(bite.toString());
    }

    return String.format("%s %s", 
                         sign.toString(),
                         sb.toString());
  }

}
