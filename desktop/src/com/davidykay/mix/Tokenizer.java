package com.davidykay.mix;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.model.Address;
import com.davidykay.mix.model.ByteFactory;
import com.davidykay.mix.model.Command;
import com.davidykay.mix.model.Field;
import com.davidykay.mix.model.Index.IndexFactory;
import com.davidykay.mix.model.Opcode;
import com.davidykay.mix.model.Opcode.OpcodeFactory;
import com.google.inject.Inject;

public class Tokenizer {
  
  private ByteFactory mByteFactory;
  private IndexFactory mIndexFactory;

  @Inject
  public Tokenizer(ByteFactory byteFactory, IndexFactory indexFactory) {
    mByteFactory = byteFactory;
    mIndexFactory = indexFactory;
  }

  public Command parse(String line) throws ByteSizeException {
    // Direct use of Pattern:
    Pattern p = Pattern.compile(
        //"(\\w+) (\\d+),? (\\S+)");
        "(\\w+) (\\d+)");
    Matcher m = p.matcher(line);
    m.find();
    String opcodeString  = m.group(1);
    String addressString = m.group(2);
    System.out.println("OPCODE found: "  + opcodeString);
    System.out.println("ADDRESS found: " + addressString);

    Opcode opcode   = OpcodeFactory.opcodeFromString(opcodeString);
    Address address = new Address(Integer.parseInt(addressString));
    
    Command command = new Command(
        opcode,
        address,
        mIndexFactory.make(0),
        new Field()
        );

    return command;
  }

}
