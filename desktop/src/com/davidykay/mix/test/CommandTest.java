package com.davidykay.mix.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.exception.InvalidWordSizeException;
import com.davidykay.mix.model.Address;
import com.davidykay.mix.model.BinaryByteFactory;
import com.davidykay.mix.model.MIXByte;
import com.davidykay.mix.model.ByteFactory;
import com.davidykay.mix.model.Command;
import com.davidykay.mix.model.Field;
import com.davidykay.mix.model.Index;
import com.davidykay.mix.model.Opcode;
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
    ByteFactory byteFactory = new BinaryByteFactory();    
    
    Command nop = new Command(
     new Opcode(Opcode.Type.ADD),
     new Address(0000),
     new Index(0),
     new Field(0, 5)
   );

    MIXByte [] bytes = new MIXByte[] { 
      byteFactory.create(0),
      byteFactory.create(0),
      byteFactory.create(0),
      byteFactory.create(0),
      byteFactory.create(0),
    };
    Word expected = new Word(
      Sign.POSITIVE,
      bytes
    );
    Word observed = nop.toWord();

    assertEquals(expected, observed);
    
    Command add = new Command(
     new Opcode(Opcode.Type.ADD),
     new Address(0000),
     new Index(0),
     new Field(0, 5)
   );

  }

}
