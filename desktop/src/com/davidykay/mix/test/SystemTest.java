package com.davidykay.mix.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.davidykay.mix.Tokenizer;
import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.model.Address;
import com.davidykay.mix.model.BinaryByteFactory;
import com.davidykay.mix.model.ByteFactory;
import com.davidykay.mix.model.Command;
import com.davidykay.mix.model.Field;
import com.davidykay.mix.model.Opcode;

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

  }

  @Test
  public void testTokenize() throws ByteSizeException {
    
    ByteFactory byteFactory = new BinaryByteFactory();

    Tokenizer tokenizer = new Tokenizer(byteFactory);

    Command expected = new Command(
     new Opcode(Opcode.Type.LDA),
     new Address(0000),
     byteFactory.create(0),
     new Field(0, 5)
   );
    
    Command observed = tokenizer.parse("LDA 0000");

    assertEquals(expected, observed);
    
    expected = new Command(
     new Opcode(Opcode.Type.LDA),
     new Address(2000),
     byteFactory.create(1),
     new Field(5, 5)
   );
    
    observed = tokenizer.parse("LDA 2000, 1(5:5)");

    assertEquals(expected, observed);
  }

}
