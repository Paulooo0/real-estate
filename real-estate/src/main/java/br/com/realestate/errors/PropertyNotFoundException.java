package br.com.realestate.errors;

public class PropertyNotFoundException extends Exception {

    public PropertyNotFoundException(Long propertyId) {
        super("Property with id " + propertyId + " not found");
    }
}
