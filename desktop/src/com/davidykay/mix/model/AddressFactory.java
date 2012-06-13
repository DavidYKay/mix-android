package com.davidykay.mix.model;

import com.davidykay.mix.exception.ByteSizeException;
import com.google.inject.Inject;

public class AddressFactory {
  private Context mContext;

  @Inject
  public AddressFactory(Context context) {
    mContext = context;
  }

  public Address make(int address) {
    ByteFactory byteFactory = mContext.getByteFactory();
    
    MIXByte[] bytes = byteFactory.makeArrayWithValue(address);
    if (bytes.length == 1) {
      try {
        bytes = new MIXByte[] {
            byteFactory.make(0),
            bytes[0]          
        };
      } catch (ByteSizeException e) {        
        e.printStackTrace();
        throw new RuntimeException("This should never happen. Bytesize 0 is illegal.");
      }
    }
    return new Address(bytes);
  }
}