package com.davidykay.mix.model;

import com.davidykay.mix.exception.InvalidWordSizeException;

public abstract class Register {

//  public abstract MIXByte[] getBytes();
//  public abstract Sign getSign();
//  
//  public abstract void setBytes(MIXByte[] mIXBytes);
//  public abstract void setSign(Sign sign);
  
  protected static final int NUM_BYTES = 0;

  protected MIXByte[] mBytes;
  protected Sign mSign;

  public Register() {
    mBytes = new MIXByte[NUM_BYTES];
    mSign = Sign.POSITIVE;
  }

  public MIXByte[] getBytes() {
    return mBytes;
  }

  public Sign getSign() {
    return mSign;
  }

  public void setBytes(MIXByte[] bytes) throws InvalidWordSizeException {
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
