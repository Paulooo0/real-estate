package br.com.realestate.errors;

public class EntityAttributeValueAlreadyExists extends Exception {
  
  public EntityAttributeValueAlreadyExists(String entityName, String attibuteName, Object value) {
    super(entityName + " with " + attibuteName + " " + value + " already exists");
  }
  
}
