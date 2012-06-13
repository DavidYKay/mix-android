package com.davidykay.mix.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davidykay.mix.model.MIXByte;
import com.davidykay.mix.model.Opcode;

public class OpcodeTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test() {
    Opcode opcode = new Opcode(Opcode.Type.LDA);
    MIXByte bite = opcode.toByte();
    fail("Not yet implemented");
  }

}
