package br.com.realestate.errors;

/**
 * The WeakPasswordException class is a custom exception that is thrown when a password is considered
 * too weak.
 */

public class WeakPasswordException extends Exception {

  public WeakPasswordException() {
    super("Too weak password. Needs at least 8 characters with one number, letter and special character");
  }
}
