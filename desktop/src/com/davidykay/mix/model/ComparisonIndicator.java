package com.davidykay.mix.model;

public class ComparisonIndicator {

  public enum ComparisonState {
    LESS_THAN,
    GREATER_THAN,
    EQUAL,
  }

  ComparisonState state = ComparisonState.EQUAL;

}
