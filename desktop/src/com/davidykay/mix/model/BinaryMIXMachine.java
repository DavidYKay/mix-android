package com.davidykay.mix.model;

import com.google.inject.Inject;

public class BinaryMIXMachine implements MIXMachine {
  
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
  public BinaryMIXMachine(Context context) {
    if (context.getNumberSystem() != NumberSystem.BINARY) {
      throw new IllegalArgumentException("BinaryMIXMachine must be invoked with binary number system!");
    }
    mContext = context;
  }

  public void execute(Command command) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Context getContext() {
    return mContext;
  }

}
