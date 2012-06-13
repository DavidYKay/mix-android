package com.davidykay.mix.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.model.ByteFactory;
import com.davidykay.mix.model.Context;
import com.davidykay.mix.model.NumberSystem;
import com.davidykay.mix.model.Opcode;
import com.davidykay.mix.model.OpcodeFactory;

public class OpcodeTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test() throws ByteSizeException {
    Context context = new Context(NumberSystem.BINARY);
    ByteFactory byteFactory = context.getByteFactory();
    OpcodeFactory opcodeFactory = context.getOpcodeFactory();

    Opcode nop = opcodeFactory.opcodeFromString("NOP");
    assertEquals(byteFactory.make(0), nop.toByte());
    
    Opcode add = opcodeFactory.opcodeFromString("ADD");
    assertEquals(byteFactory.make(1), add.toByte());
    
    Opcode jx = opcodeFactory.opcodeFromString("JX");
    assertEquals(byteFactory.make(47), jx.toByte());
  }

}
