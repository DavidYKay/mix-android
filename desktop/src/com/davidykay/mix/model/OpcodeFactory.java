package com.davidykay.mix.model;

import com.google.inject.Inject;

public class OpcodeFactory {

  private ByteFactory mByteFactory;
  @Inject
  public OpcodeFactory(ByteFactory byteFactory) {
    mByteFactory = byteFactory;
  }

  public Opcode opcodeFromString(String opcodeName) {
    Opcode.Type type = Enum.valueOf(Opcode.Type.class, opcodeName);
    return new Opcode(type, mByteFactory);
  }
}