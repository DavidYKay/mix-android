package com.davidykay.mix.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.exception.InvalidWordSizeException;
import com.davidykay.mix.model.Address;
import com.davidykay.mix.model.AddressFactory;
import com.davidykay.mix.model.ByteFactory;
import com.davidykay.mix.model.Command;
import com.davidykay.mix.model.Context;
import com.davidykay.mix.model.Field;
import com.davidykay.mix.model.Index;
import com.davidykay.mix.model.MIXByte;
import com.davidykay.mix.model.NumberSystem;
import com.davidykay.mix.model.OpcodeFactory;
import com.davidykay.mix.model.Sign;
import com.davidykay.mix.model.Word;

public class CommandTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testToWord() throws ByteSizeException, InvalidWordSizeException {

    Context context = new Context(NumberSystem.BINARY);
    ByteFactory byteFactory = context.getByteFactory();
    AddressFactory addressFactory = context.getAddressFactory();
    OpcodeFactory opcodeFactory = context.getOpcodeFactory();
    
    Command nop = new Command(
     opcodeFactory.opcodeFromString("NOP"),
     addressFactory.make(0000),
     new Index(byteFactory.make(0)),
     new Field(0, 5, context)
   );

    MIXByte [] bytes = new MIXByte[] { 
      byteFactory.make(0),
      byteFactory.make(0),
      byteFactory.make(0),
      byteFactory.make(5),
      byteFactory.make(0),
    };
    Word expected = new Word(
      Sign.POSITIVE,
      bytes
    );
    Word observed = nop.toWord();

    assertEquals(expected, observed);
    
    Command add = new Command(
     opcodeFactory.opcodeFromString("ADD"),
     addressFactory.make(0000),
     new Index(byteFactory.make(0)),
     new Field(0, 5, context)
   );

  }

}
