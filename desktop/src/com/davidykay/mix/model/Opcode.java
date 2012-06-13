package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;

public class Opcode implements Byteable {

  public Type type;
  private ByteFactory mByteFactory;

  public Opcode(Type type, ByteFactory byteFactory) {
    this.type = type;
    mByteFactory = byteFactory;
  }

  public enum Type {

    NOP(0),
    ADD(1),
    SUB(2),
    MUL(3),
    DIV(4),
    MOVE(7),
    LDA(8),
    LD1(9),
    LD2(10),
    LD3(11),
    LD4(12),
    LD5(13),
    LD6(14),
    LDX(15),
    LDAN(16),
    LD1N(17),
    LD2N(18),
    LD3N(19),
    LD4N(20),
    LD5N(21),
    LD6N(22),
    LDXN(23),
    STA(24),
    ST1(25),
    ST2(26),
    ST3(27),
    ST4(28),
    ST5(29),
    ST6(30),
    STX(31),
    STJ(32),
    STZ(33),
    JBUS(34),
    IOC(35),
    IN(36),
    OUT(37),
    JRED(38),
    JMP(39),
    JA(40),
    J1(41),
    J2(42),
    J3(43),
    J4(44),
    J5(45),
    J6(46),
    JX(47);

    private int mValue;
    Type(int value) {
      mValue = value;
    }

    public int getValue() {
      return mValue;
    }
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

  public MIXByte toByte() {
    try {
      return mByteFactory.make(this.type.getValue());
    } catch (ByteSizeException e) {
      throw new RuntimeException("Programmer is an idiot. This Opcode has not been implemented correctly: " + this);     
    }
  }

}
