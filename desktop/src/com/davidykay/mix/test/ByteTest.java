package com.davidykay.mix.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.model.BinaryByteFactory;
import com.davidykay.mix.model.ByteFactory;
import com.davidykay.mix.model.MIXByte;
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
    MIXByte[] sixtyFive  = new MIXByte[] {
      binaryFactory.make(1),
      binaryFactory.make(1),
    };
    assertEquals(65, MIXByte.valueOfArray(sixtyFive));

    MIXByte[] fourThousand  = new MIXByte[] {
      binaryFactory.make(62),
      binaryFactory.make(32),
    };
    assertEquals(4000, MIXByte.valueOfArray(fourThousand));

    
    ByteFactory decimalFactory = new DecimalByteFactory();
    MIXByte[] oneOhOne  = new MIXByte[] {
      decimalFactory.make(1),
      decimalFactory.make(1),
    };
    assertEquals(101, MIXByte.valueOfArray(oneOhOne));


  }
}
