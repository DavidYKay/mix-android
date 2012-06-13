package com.davidykay.mix.model;

public class Field implements Byteable {
  public static final int DEFAULT_LOWER = 0;
  public static final int DEFAULT_UPPER = 5;
  
  public int lower;
  public int upper;
  
  public Field() {
    this(DEFAULT_LOWER, DEFAULT_UPPER);
  }

  public Field(int i, int j) {
    lower = i;
    upper = j;
  }
  
  public String toString() {
    return String.format("(%d:%d)",
                         lower,
                         upper);
  }
  
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Field)) {
      return false;
    }
    Field other = (Field) o;
    if (other.upper != this.upper) {
      return false;
    }
    if (other.lower != this.lower) {
      return false;
    }
    return true;
  }

  public MIXByte toByte() {
    // TODO Auto-generated method stub
    return null;
  }

}
