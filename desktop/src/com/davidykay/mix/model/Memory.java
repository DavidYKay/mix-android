package com.davidykay.mix.model;

import com.google.inject.Inject;

public class Memory {
  private static final int MEMORY_SIZE = 4000;
  
  private Context mContext;
  private Word[] mStorage;
  
  @Inject public Memory(Context context) {
    mContext = context;
    
  }
  
  public Word get(int address) {
    return mStorage[address];
  }
  
  public void set(int address, Word word) {
    mStorage[address] = word;
  }
}
