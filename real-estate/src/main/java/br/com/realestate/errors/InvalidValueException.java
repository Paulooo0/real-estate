package br.com.realestate.errors;

public class InvalidValueException extends Exception {

  // public InvalidValueException(String message) {
  //   super(message);
  // }

  public InvalidValueException(String fieldName, Object value) {
    super(value + " in " + fieldName + " is invalid");
  }
}
