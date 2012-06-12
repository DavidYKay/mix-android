package com.davidykay.mix.model;

import com.davidykay.mix.exception.InvalidWordSizeException;
import com.google.inject.Inject;

public class Command {

  public Address address;
  public Field field;
  public Index index;
  public Opcode opcode;

  @Inject
  public Command (
      Opcode opcode,
      Address address,
      Index index,
      Field field
      ) {
    if (
        opcode != null &&
        address != null &&
        index != null &&
        field != null)
    {
      this.opcode  = opcode ;
      this.address = address;
      this.index   = index  ;
      this.field   = field  ;
    } else {
      throw new IllegalArgumentException("Arguments must not be null!");
    }
  }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Command)) {
      return false;
    }
    Command other = (Command) o;
    if (!other.address.equals(this.address)) {
      return false;
    }
    if (!other.field.equals(this.field)) {
      return false;
    }
    if (!other.index.equals(this.index)) {
      return false;
    }
    if (!other.opcode.equals(this.opcode)) {
      return false;
    }
    return true;
  }

  public String toString() {
    return String.format("%s %s,%s(%s)",
                         opcode.toString(),
                         address.toString(),
                         index.toString(),
                         field.toString()
                        );
  }
  
  public Word toWord() throws InvalidWordSizeException {
    Byte[] addressBytes = this.address.toBytes();

    //Byte[] bytes = null;
    Byte[] bytes = new Byte[] {
      addressBytes[0],
      addressBytes[1],
      this.index.toByte(),
      this.field.toByte(),
      this.opcode.toByte()
    };

    return new Word(
        Sign.POSITIVE,
        bytes
    );
  }

}
