package br.com.realestate.errors;

/**
 * The PropertyNotFoundException class is a custom exception that is thrown when a property with a
 * specific id is not found.
 */

public class PropertyNotFoundException extends Exception {

    public PropertyNotFoundException(Long propertyId) {
        super("Property with id " + propertyId + " not found");
    }
}
