package com.davidykay.mix.model;

import com.davidykay.mix.exception.InvalidWordSizeException;

public abstract class Register {

//  public abstract Byte[] getBytes();
//  public abstract Sign getSign();
//  
//  public abstract void setBytes(Byte[] bytes);
//  public abstract void setSign(Sign sign);
  
  protected static final int NUM_BYTES = 0;

  protected Byte[] mBytes;
  protected Sign mSign;

  public Register() {
    mBytes = new Byte[NUM_BYTES];
    mSign = Sign.POSITIVE;
  }

  public Byte[] getBytes() {
    return mBytes;
  }

  public Sign getSign() {
    return mSign;
  }

  public void setBytes(Byte[] bytes) throws InvalidWordSizeException {
    if (bytes.length > NUM_BYTES) {
      throw new InvalidWordSizeException("Exceeded register size of: " + NUM_BYTES);
    } else {
      mBytes = bytes;
    }
  }

  public void setSign(Sign sign) {
    mSign = sign;
  }

}
