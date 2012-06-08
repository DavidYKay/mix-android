package com.davidykay.mix.model;

public class InvalidAddressException extends IllegalArgumentException {

  public InvalidAddressException(String string) {
    super(string);
  }

}