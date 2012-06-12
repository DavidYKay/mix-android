package com.davidykay.mix.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davidykay.mix.model.Byte;
import com.davidykay.mix.model.Field;

public class FieldTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test() {
    Field field = new Field(0,5);
    Byte bite = field.toByte();
    fail("Not yet implemented");
  }

}
