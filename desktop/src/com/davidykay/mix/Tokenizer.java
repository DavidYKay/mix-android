package com.davidykay.mix;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.davidykay.mix.exception.ByteSizeException;
import com.davidykay.mix.model.Address;
import com.davidykay.mix.model.Command;
import com.davidykay.mix.model.Context;
import com.davidykay.mix.model.Field;
import com.davidykay.mix.model.Index;
import com.davidykay.mix.model.Opcode;
import com.google.inject.Inject;

public class Tokenizer {

  private Context mContext;
//  private ByteFactory mByteFactory;
//  private IndexFactory mIndexFactory;

  @Inject
  public Tokenizer(Context context) {
    mContext = context;
    //mIndexFactory = indexFactory;
  }

  private Index parseIndex(String indexString) throws ParseException {
    try{
    if (indexString == null) {
      return mContext.getIndexFactory().make();
    } else {
      return mContext.getIndexFactory().make(
          Integer.parseInt(indexString)
      );
    }
    } catch (ByteSizeException ex) {
      throw new ParseException("Invalid Index: " + indexString, -1);
    }
  }

  private Field parseField(String fieldString) {
    if (fieldString == null) {
      return new Field(mContext);
    } else {
      Pattern p = Pattern.compile(
          "([0-9]):([0-9])"
          );
      Matcher m = p.matcher(fieldString);
      m.find();
      String lowerString  = m.group(1);
      String upperString  = m.group(2);

      return new Field(
          Integer.parseInt(lowerString),
          Integer.parseInt(upperString),
          mContext
          );
    }
  }

  public Command parse(String line) throws ByteSizeException {

    // Regex tester:
    // http://www.regexplanet.com/advanced/java/index.html

    // Regex 1
    //(\w+) (\d+)(?:, )?([0-9]+)?([()0-9:]+)?
    // Java equiv
    //"(\\w+) (\\d+)(?:, )?([0-9]+)?([()0-9:]+)?"

    // Direct use of Pattern:
    Pattern p = Pattern.compile(
        "(\\w+) (\\d+)(?:, )?([0-9]+)?([()0-9:]+)?"
        );
    Matcher m = p.matcher(line);
    m.find();
    String opcodeString  = m.group(1);
    String addressString = m.group(2);
    String indexString   = m.group(3);
    String fieldString   = m.group(4);


    System.out.println("OPCODE found: "  + opcodeString);
    System.out.println("ADDRESS found: " + addressString);

    Opcode opcode   = mContext.getOpcodeFactory().opcodeFromString(opcodeString);
    Address address = mContext.getAddressFactory().make(Integer.parseInt(addressString));
    Field field = parseField(fieldString);

    Index index;
    try {
      index = parseIndex(indexString);
    } catch (ParseException e) {
      e.printStackTrace();
      throw new RuntimeException("Failed to parse line " + line);
    }

    Command command = new Command(
        opcode,
        address,
        index,
        field
        );

    return command;
  }

}
