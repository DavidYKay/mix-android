package com.davidykay.mix.model;

import com.google.inject.Inject;

public class DecimalMIXMachine implements MIXMachine {
  
  @Inject protected Memory mMemory;
  
  @Inject protected WordRegister mRegisterA    ;
  @Inject protected WordRegister mRegisterX    ;
  @Inject protected IndexRegister mRegisterI1   ;
  @Inject protected IndexRegister mRegisterI2   ;
  @Inject protected IndexRegister mRegisterI3   ;
  @Inject protected IndexRegister mRegisterI4   ;
  @Inject protected IndexRegister mRegisterI5   ;
  @Inject protected IndexRegister mRegisterI6   ;
  @Inject protected JumpRegister mJumpRegister;
  
  @Inject protected OverflowIndicator mOverflowIndicator;
  @Inject protected ComparisonIndicator mComparisonIndicator;

  protected Context mContext;
  
  @Inject
  public DecimalMIXMachine(Context context) {
    if (context.numberSystem != NumberSystem.DECIMAL) {
      throw new IllegalArgumentException("DecimalMIXMachine must be invoked with binary number system!");
    }
    mContext = context;
  }
  
  @Override
  public Context getContext() {
    return mContext;
  }

}
