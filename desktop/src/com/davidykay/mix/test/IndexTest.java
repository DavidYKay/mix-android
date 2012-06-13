package com.davidykay.mix.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.exception.InvalidIndexException;
import com.davidykay.mix.model.Context;
import com.davidykay.mix.model.Index;
import com.davidykay.mix.model.IndexFactory;
import com.davidykay.mix.model.MIXByte;
import com.davidykay.mix.model.NumberSystem;

public class IndexTest {
  
  private IndexFactory mIndexFactory;

//  @Inject
//  public IndexTest(IndexFactory indexFactory) {
//    mIndexFactory = indexFactory;
//  }

  @Before
  public void setUp() throws Exception {
    Context context = new Context(NumberSystem.BINARY);
    mIndexFactory = context.getIndexFactory();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testBounds() throws ByteSizeException {
    
    try {
      Index index = mIndexFactory.make(-1);
      fail("Index -1 should be illegal");
    } catch (InvalidIndexException ex) {
      // NOP
    }

    try {
      Index index = mIndexFactory.make(7);
      fail("Index 7 should be illegal");
    } catch (InvalidIndexException ex) {
      // NOP
    }

    try {
      Index index = mIndexFactory.make(0);
    } catch (InvalidIndexException ex) {
      fail("Index 0 should be illegal");
    }

    try {
      Index index = mIndexFactory.make(6);
    } catch (InvalidIndexException ex) {
      fail("Index 6 should be illegal");
    }

  }

  @Test
  public void test() throws ByteSizeException {
    Index index = mIndexFactory.make(0);
    MIXByte bite = index.toByte();
    assertEquals(0, bite.value());

  }

}
