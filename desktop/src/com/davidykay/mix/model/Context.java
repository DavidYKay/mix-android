package com.davidykay.mix.model;

import com.google.inject.Inject;

public class Context {

  private NumberSystem mNumberSystem;
  private BinaryByteFactory mByteFactory;

  @Inject
  public Context(NumberSystem numberSystem) {
    mNumberSystem = numberSystem;
    if (mNumberSystem == NumberSystem.BINARY) {
      mByteFactory = new BinaryByteFactory();
    }
  }

  public NumberSystem getNumberSystem() {
    return mNumberSystem;
  }

  public OpcodeFactory getOpcodeFactory() {    
    return new OpcodeFactory(mByteFactory);   
  }

  public ByteFactory getByteFactory() {
    return mByteFactory;
  }

  public IndexFactory getIndexFactory() {
    return new IndexFactory(mByteFactory);
  }

  public AddressFactory getAddressFactory() {
    return new AddressFactory(this);
  }

}
