package com.davidykay.mix.model;

import com.google.inject.Inject;

public class BinaryMIXMachine implements MIXMachine {
  private static final int MEMORY_SIZE = 4000;

  private Word[] mMemory = new Word[MEMORY_SIZE];
  
  @Inject private Register mRegisterA    ;
  @Inject private Register mRegisterX    ;
  @Inject private Register mRegisterI1   ;
  @Inject private Register mRegisterI2   ;
  @Inject private Register mRegisterI3   ;
  @Inject private Register mRegisterI4   ;
  @Inject private Register mRegisterI5   ;
  @Inject private Register mRegisterI6   ;
  @Inject private Register mJumpRegister;

  public void execute(Command command) {
    // TODO Auto-generated method stub
    
  }
  
}
