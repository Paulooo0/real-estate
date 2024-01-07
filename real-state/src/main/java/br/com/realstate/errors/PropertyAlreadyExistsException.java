package br.com.realstate.errors;

public class PropertyAlreadyExistsException extends Exception {
    
    public PropertyAlreadyExistsException(String street, Integer addressNumber) {
        super(String.format("""
                Property with address %s, %d already exists
                """, street, addressNumber));
    }    
}
