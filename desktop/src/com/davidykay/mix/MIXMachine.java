package com.davidykay.mix;

public class MIXMachine {
  private static final int MEMORY_SIZE = 4000;

  private Word[] mMemory = new Word[MEMORY_SIZE];
  
  private Register mRegisterA = new Register();
  private Register mRegisterX = new Register();
  
  private Register mRegisterI1 = new Register();
  private Register mRegisterI2 = new Register();
  private Register mRegisterI3 = new Register();
  private Register mRegisterI4 = new Register();
  private Register mRegisterI5 = new Register();
  private Register mRegisterI6 = new Register();
  
  private Register mJumpRegister = new Register();

  public void execute(Command command) {
    // TODO Auto-generated method stub
    
  }
  
}