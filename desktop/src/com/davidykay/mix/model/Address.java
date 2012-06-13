package com.davidykay.mix.model;

import com.davidykay.mix.exception.InvalidAddressException;

public class Address {

  public static final int MIN_ADDRESS = 0;
  public static final int MAX_ADDRESS = 3999;

  private int mAddress;
  private MIXByte[] mBytes;

  public Address(MIXByte[] bytes) {
    if (bytes.length != 2) {
      throw new IllegalArgumentException("Address must be two bytes long.");
    }

    int i = MIXByte.valueOfArray(bytes);

    if (i < MIN_ADDRESS) {
      throw new InvalidAddressException("Address cannot be less than " + MIN_ADDRESS);
    }
    if (i > MAX_ADDRESS) {
      throw new InvalidAddressException("Address cannot be more than " + MAX_ADDRESS);
    }

    mAddress = i;
    mBytes = bytes;
  }

  public String toString() {
    return String.format("%d", mAddress);
  }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Address)) {
      return false;
    }
    Address other = (Address) o;
    if (other.value() != this.value()) {
      return false;
    }
    return true;
  }
  
  public int value() {
    return mAddress;
  }

  public MIXByte[] toBytes() {
    return mBytes;
  }

}
