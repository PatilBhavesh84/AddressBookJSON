package com.bridgelabz;

import java.util.Comparator;
//An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).
public enum sortOptions {
  NAME(Comparator.comparing(Person::getFirstName)),
  CITY(Comparator.comparing(Person::getCity)),
  STATE(Comparator.comparing(Person::getState)),
  ZIP(Comparator.comparing(Person::getZip));

  public final Comparator<? super Person> comparator;
  sortOptions(Comparator<? super Person> comparator) {
      this.comparator = comparator;
  }
}
