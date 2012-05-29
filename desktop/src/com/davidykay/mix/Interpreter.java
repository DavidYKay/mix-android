package com.davidykay.mix;

public class Interpreter {

  private MIXMachine mMachine;
  private Tokenizer mTokenizer;

  public Interpreter(MIXMachine machine, Tokenizer tokenizer) {
    mMachine = machine;
    mTokenizer = tokenizer;
  }

  public void eval(String code) {
    // break code into lines
    String[] lines = code.split("\n");

    for (String line : lines) {
      // for each line, tokenize
      Command command = mTokenizer.parse(line);
      // then execute the tokens
      mMachine.execute(command);
    }

  }

}
