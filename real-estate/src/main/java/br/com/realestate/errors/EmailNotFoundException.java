package br.com.realestate.errors;

public class EmailNotFoundException extends Exception {
    
    public EmailNotFoundException(String email) {
        super("Email " + email + " not found");
    }
    
}
