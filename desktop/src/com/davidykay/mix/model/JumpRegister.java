package com.davidykay.mix.model;

import com.davidykay.mix.exception.HardwareNonExistantException;

public class JumpRegister extends Register {
  
  protected static final int NUM_BYTES = 2;

  @Override
  public Sign getSign() {
    return Sign.POSITIVE;
  }

  @Override
  public void setSign(Sign sign) {
    throw new HardwareNonExistantException("This hardware does not exist in MIX!");    
  }

}
