package com.davidykay.mix.model;

import java.util.Arrays;

import com.davidykay.mix.exception.InvalidWordSizeException;
import com.google.inject.Inject;

public class Word {

  public static final int WORD_SIZE = 5;

  public Sign sign    ;
  public MIXByte[] bytes ;

  @Inject
  public Word(Sign sign, MIXByte[] bytes) throws InvalidWordSizeException {
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
    for (MIXByte bite : bytes) {
      sb.append(bite.toString());
    }

    return String.format("%s %s",
                         sign.toString(),
                         sb.toString());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.hashCode(bytes);
    result = prime * result + ((sign == null) ? 0 : sign.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Word other = (Word) obj;
    if (!Arrays.equals(bytes, other.bytes))
      return false;
    if (sign != other.sign)
      return false;
    return true;
  }

}
