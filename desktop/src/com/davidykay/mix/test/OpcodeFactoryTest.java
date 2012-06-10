package com.davidykay.mix.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davidykay.mix.model.Opcode;
import com.davidykay.mix.model.Opcode.OpcodeFactory;

public class OpcodeFactoryTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test() {

    HashMap<String, Opcode> values = new HashMap<String, Opcode>();
    values.put("LDA", new Opcode(Opcode.Type.LDA));
    values.put("ADD", new Opcode(Opcode.Type.ADD));
    values.put("SUB", new Opcode(Opcode.Type.SUB));

    for (Map.Entry<String, Opcode> entry : values.entrySet()) {
      assertEquals(
          OpcodeFactory.opcodeFromString(entry.getKey()),
          entry.getValue()
          );
    }
  }

}
