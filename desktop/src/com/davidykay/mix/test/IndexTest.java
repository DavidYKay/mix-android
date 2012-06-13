package com.davidykay.mix.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davidykay.mix.exception.InvalidIndexException;
import com.davidykay.mix.model.MIXByte;
import com.davidykay.mix.model.Index;

public class IndexTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testBounds() {
    boolean threwException = false;
    try {
      Index index = new Index(-1);
      fail("Index -1 should be illegal");
    } catch (InvalidIndexException ex) {
      threwException = true;
    }

    try {
      Index index = new Index(7);
      fail("Index 7 should be illegal");
    } catch (InvalidIndexException ex) {
      threwException = true;
    }

    try {
      Index index = new Index(0);
    } catch (InvalidIndexException ex) {
      fail("Index 0 should be illegal");
    }

    try {
      Index index = new Index(6);
    } catch (InvalidIndexException ex) {
      fail("Index 6 should be illegal");
    }

  }

  @Test
  public void test() {
    Index index = new Index(0);
    MIXByte bite = index.toByte();
    assertEquals(0, bite.value());

  }

}
