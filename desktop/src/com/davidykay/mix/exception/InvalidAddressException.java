package com.davidykay.mix.exception;

public class InvalidAddressException extends IllegalArgumentException {

  public InvalidAddressException(String string) {
    super(string);
  }

}