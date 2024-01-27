package br.com.realestate.errors;

/**
 * The InvalidValueException class is a custom exception that is thrown when an invalid value is
 * encountered in a specific field.
 */

public class InvalidValueException extends Exception {

  public InvalidValueException(String fieldName, Object value) {
    super(value + " in " + fieldName + " is invalid");
  }
}
