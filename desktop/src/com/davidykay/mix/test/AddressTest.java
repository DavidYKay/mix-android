package com.davidykay.mix.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.davidykay.mix.model.Address;

public class AddressTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  private void createAddressWithNumber(int number, boolean shouldFail) {
    boolean threwException = false;
    try {
      Address address = new Address(number);
    } catch (IllegalArgumentException ex) {
      threwException = true;
    } finally {
      if (shouldFail) {
        if (threwException) {
          // Pass!
        } else {
          String failSucceedString = shouldFail ? "fail" : "succeed";
          fail(String.format("Address: %d should %s.", number, failSucceedString));
          //fail("Exception not thrown!");
        }
      } else {
        if (threwException) {
          //fail("Exception thrown!");
          String failSucceedString = shouldFail ? "fail" : "succeed";
          fail(String.format("Address: %d should %s.", number, failSucceedString));
        } else {
          // Pass!
        }
      }
    }
  }

  @Test
  public void parseTest() {
    createAddressWithNumber(0, false);
    createAddressWithNumber(3999, false);
    createAddressWithNumber(-1, true);
    createAddressWithNumber(4000, true);
  }

}
