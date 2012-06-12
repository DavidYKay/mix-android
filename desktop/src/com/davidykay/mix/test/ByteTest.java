package com.davidykay.mix.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.model.BinaryByteFactory;
import com.davidykay.mix.model.ByteFactory;
import com.davidykay.mix.model.Byte;
import com.davidykay.mix.model.DecimalByteFactory;

public class ByteTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }
  
  @Test
  public void testSum() throws ByteSizeException {
    ByteFactory binaryFactory = new BinaryByteFactory();
    Byte[] sixtyFive  = new Byte[] {
      binaryFactory.create(1),
      binaryFactory.create(1),
    };
    assertEquals(65, Byte.valueOfArray(sixtyFive));
    
    ByteFactory decimalFactory = new DecimalByteFactory();
    Byte[] oneOhOne  = new Byte[] {
      decimalFactory.create(1),
      decimalFactory.create(1),
    };
    assertEquals(101, Byte.valueOfArray(oneOhOne));
  }
}
