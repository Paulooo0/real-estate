package br.com.realestate.errors;

/**
 * The PhoneNotFoundException class is a custom exception that is thrown when a phone is not found.
 */

public class PhoneNotFoundException extends Exception {

    public PhoneNotFoundException(String phone) {
        super("Phone " + phone + " not found");
    }
}
