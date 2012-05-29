package com.davidykay.mix;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.model.Address;
import com.davidykay.mix.model.ByteFactory;
import com.davidykay.mix.model.Command;
import com.davidykay.mix.model.Field;
import com.davidykay.mix.model.Opcode;
import com.google.inject.Inject;

public class Tokenizer {
  
  private ByteFactory mByteFactory;

  @Inject
  public Tokenizer(ByteFactory byteFactory) {
    mByteFactory = byteFactory;
  }

  public Command parse(String line) throws ByteSizeException {
    
    Command command = new Command(
        new Opcode(Opcode.Type.LDA),
        new Address(0000),
        mByteFactory.create(0),
        new Field()
        );
    return command;
  }

}
