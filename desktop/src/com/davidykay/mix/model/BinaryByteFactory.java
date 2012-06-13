package com.davidykay.mix.model;

import java.util.ArrayList;
import java.util.List;

import com.davidykay.mix.exception.ByteSizeException;

public class BinaryByteFactory implements ByteFactory {
  @Override
  public MIXByte make(int i) throws ByteSizeException {
    MIXByte bite = new BinaryByte();
    bite.set(i);
    return bite;
  }

  @Override
  public MIXByte[] makeArrayWithValue(int value) {    
    // change of base
    List<MIXByte> byteList;
    try {
      byteList = recursiveArrayWithValue(value);
    } catch (ByteSizeException e) {
      e.printStackTrace();
      throw new RuntimeException("BinaryByteFactory's makeArray is broken! Value: " + value);
    }
    MIXByte[] bytes = new MIXByte[byteList.size()];
    return byteList.toArray(bytes);
  }
  
  private List<MIXByte> recursiveArrayWithValue(int value) throws ByteSizeException {
    int columnValue = make(0).getValueCount();

    if (value < columnValue) {
      List<MIXByte> list = new ArrayList<MIXByte>();      
      MIXByte bite = make(value);
      list.add(bite);
      return list;
    } else {
      int k = value / columnValue;
      int b = value % columnValue;

      List<MIXByte> E = recursiveArrayWithValue(k);

      E.add(make(b));
      return E;
    }
  }

  @Override
  public MIXByte[] makeArrayWithIntArray(int[] values) throws ByteSizeException {
    MIXByte[] bytes = new MIXByte[values.length];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = make(values[i]);
    }
    return bytes;
  }

}
