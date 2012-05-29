package com.davidykay.mix.model;

public class Address {

  public int address;
  
  public Address(int i) {
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

}
