package com.davidykay.mix;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.model.Command;
import com.davidykay.mix.model.BinaryMIXMachine;

public class Interpreter {

  private BinaryMIXMachine mMachine;
  private Tokenizer mTokenizer;

  public Interpreter(BinaryMIXMachine machine, Tokenizer tokenizer) {
    mMachine = machine;
    mTokenizer = tokenizer;
  }

  public void eval(String code) throws ByteSizeException {
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
