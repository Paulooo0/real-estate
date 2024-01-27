package br.com.realestate.errors;

// The code is defining a custom exception class called `PropertyAlreadyExistsException`. This
// exception is thrown when a property with a specific address already exists.

public class PropertyAlreadyExistsException extends Exception {
    
    public PropertyAlreadyExistsException(String street, Integer addressNumber) {
        super(String.format("""
                Property with address %s, %d already exists
                """, street, addressNumber));
    }    
}
