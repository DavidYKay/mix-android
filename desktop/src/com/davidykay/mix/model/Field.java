package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;

public class Field implements Byteable {
  public static final int DEFAULT_LOWER = 0;
  public static final int DEFAULT_UPPER = 5;
  
  public int lower;
  public int upper;
  
  private Context mContext;
  
  public Field(Context context) {
    this(DEFAULT_LOWER, DEFAULT_UPPER, context);
  }

  public Field(int i, int j, Context context) {
    lower = i;
    upper = j;
    mContext = context;
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
    ByteFactory byteFactory = mContext.getByteFactory();
    try {
      return byteFactory.make(
          (8 * lower) + upper
          );
    } catch (ByteSizeException e) {
      e.printStackTrace();
      throw new RuntimeException("The programmer is an idiot! Fields should never be like this: " + this);
    }
  }

}
