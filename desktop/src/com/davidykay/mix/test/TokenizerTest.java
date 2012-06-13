package com.davidykay.mix.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.davidykay.mix.Tokenizer;
import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.model.AddressFactory;
import com.davidykay.mix.model.ByteFactory;
import com.davidykay.mix.model.Command;
import com.davidykay.mix.model.Context;
import com.davidykay.mix.model.Field;
import com.davidykay.mix.model.IndexFactory;
import com.davidykay.mix.model.NumberSystem;
import com.davidykay.mix.model.OpcodeFactory;

public class TokenizerTest {
  
  @Test
  public void testTokenize() throws ByteSizeException {
    Context context = new Context(NumberSystem.BINARY);
    ByteFactory byteFactory = context.getByteFactory();
    IndexFactory indexFactory = context.getIndexFactory();
    OpcodeFactory opcodeFactory = context.getOpcodeFactory();
    AddressFactory addressFactory = context.getAddressFactory();

    Tokenizer tokenizer = new Tokenizer(context);

    Command expected = new Command(
      opcodeFactory.opcodeFromString("LDA"),
      addressFactory.make(0000),
      indexFactory.make(0),
      new Field(0, 5, context)
    );
    
    Command observed = tokenizer.parse("LDA 0000");
    assertEquals(expected, observed);
    
    expected = new Command(
      opcodeFactory.opcodeFromString("LDA"),
      addressFactory.make(2000),
      indexFactory.make(1),
      new Field(5, 5, context)
    );
    
    observed = tokenizer.parse("LDA 2000, 1(5:5)");

    assertEquals(expected, observed);
  }

}
