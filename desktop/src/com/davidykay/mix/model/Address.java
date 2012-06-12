package com.davidykay.mix.model;

import com.davidykay.mix.exception.InvalidAddressException;

public class Address {

  public static final int MIN_ADDRESS = 0;
  public static final int MAX_ADDRESS = 3999;

  public int address;

  public static class AddressFactory {
    public Address makeFromBytes(Byte[] bytes) {
      if (bytes.length != 2) {
        throw new IllegalArgumentException("Address must be two bytes long.");
      }
      return new Address(Byte.valueOfArray(bytes));
    }
  }
  
  public Address(int i) {
    if (i < MIN_ADDRESS) {
      throw new InvalidAddressException("Address cannot be less than " + MIN_ADDRESS);
    }
    if (i > MAX_ADDRESS) {
      throw new InvalidAddressException("Address cannot be more than " + MAX_ADDRESS);
    }
    address = i;
  }

  public String toString() {
    return String.format("%d", address);
  }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Address)) {
      return false;
    }
    Address other = (Address) o;
    if (other.address != this.address) {
      return false;
    }
    return true;
  }

  public Byte[] toBytes() {
    
    return null;
  }

}
