package com.davidykay.mix.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.exception.InvalidWordSizeException;
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

    MIXByte [] bytes = byteFactory.makeArrayWithIntArray(new int[] {
        0,
        0,
        0,
        5,
        0,
    });   
    
    Word expected = new Word(
        Sign.POSITIVE,
        bytes
        );

    assertEquals(expected, nop.toWord());

    Command add = new Command(
        opcodeFactory.opcodeFromString("ADD"),
        addressFactory.make(0000),
        new Index(byteFactory.make(0)),
        new Field(0, 5, context)
        );

    bytes = byteFactory.makeArrayWithIntArray(new int[] {
        0,
        0,
        0,
        5,
        1,
    });   
    
    expected = new Word(
        Sign.POSITIVE,
        bytes
        );
    assertEquals(expected, add.toWord());


  }

}
