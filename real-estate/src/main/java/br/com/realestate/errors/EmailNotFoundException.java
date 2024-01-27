package br.com.realestate.errors;

/**
 * The EmailNotFoundException class is a custom exception that is thrown when a specific email is not
 * found.
 */

public class EmailNotFoundException extends Exception {
    
    public EmailNotFoundException(String email) {
        super("Email " + email + " not found");
    }
    
}
