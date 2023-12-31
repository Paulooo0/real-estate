package br.com.realstate.errors;

public class PropertyNotFoundException extends Exception {

    public PropertyNotFoundException(String propertyId) {
        super("Property with id " + propertyId + " not found");
    }
}
