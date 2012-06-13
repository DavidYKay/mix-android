package com.davidykay.mix.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

public class SystemTest {
  
  @Test
  public void testAddition() throws ByteSizeException {
    // Load instructions into RAM
    
    // Execute
    
    // End state should look like this:
    // A: 0
    // X: 0
    // I1: 0
    // I2: 0
    // I3: 0
    // I4: 0
    // I5: 0
    // I6: 0
    // Overflow: Off
    // CMP: Off

    fail("not yet implemented!");
  }

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
