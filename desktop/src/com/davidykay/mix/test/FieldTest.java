package com.davidykay.mix.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.model.ByteFactory;
import com.davidykay.mix.model.Context;
import com.davidykay.mix.model.Field;
import com.davidykay.mix.model.NumberSystem;

public class FieldTest {

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
    
    Field field = new Field(0, 5, context);
    assertEquals(byteFactory.make(5), field.toByte());

    field = new Field(5, 5, context);
    assertEquals(byteFactory.make(45), field.toByte());

  }

}
