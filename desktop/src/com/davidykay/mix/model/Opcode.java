package com.davidykay.mix.model;

import com.davidykay.mix.model.Opcode.Type;

public class Opcode {

  public static class OpcodeFactory {
    public static Opcode opcodeFromString(String opcodeName) {
      Opcode.Type type = Enum.valueOf(Opcode.Type.class, opcodeName);
      return new Opcode(type);
    }
  }
  
  public Type type;

  public Opcode(Type type) {
    this.type = type;
  }

  public enum Type {
    LDA,
    ADD,
    SUB,
  }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Opcode)) {
      return false;
    }
    Opcode other = (Opcode) o;
    if (!other.type.equals(this.type)) {
      return false;
    }
    return true;
  }
  
  public String toString() {
    return type.name();
  }

}
