package br.com.realestate.service;
package br.com.realestate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.realestate.errors.InvalidValueException;
import br.com.realestate.errors.PropertyAlreadyExistsException;
import br.com.realestate.model.Property;
import br.com.realestate.repository.PropertyRepository;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public void saveProperty(Property property) throws PropertyAlreadyExistsException {
        List<Property> propertiesByCep = propertyRepository.findAllByCep(property.getCep());
        for (Property p : propertiesByCep) {
            if (p.getAddressNumber().equals(property.getAddressNumber())) {
                throw new PropertyAlreadyExistsException(property.getStreet(), property.getAddressNumber());
            }
        }

        propertyRepository.save(property);
    }

    public Property findByPropertyId(Long propertyId) throws br.com.realestate.errors.PropertyNotFoundException {
        return propertyRepository.findByPropertyId(propertyId).orElseThrow(() -> new br.com.realestate.errors.PropertyNotFoundException(propertyId));
    }

    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    public List<Property> findAllPropertiesByCategory(String category) {
        return propertyRepository.findAllByCategory(category);
    }

    public List<Property> findAllPropertiesByCep(String CEP) {
        return propertyRepository.findAllByCep(CEP);
    }

    public void updateProperty(Long propertyId, Property property) throws br.com.realestate.errors.PropertyNotFoundException, InvalidValueException {
        Property existentProperty = findByPropertyId(propertyId);

        existentProperty.setCep(property.getCep());
        existentProperty.setStreet(property.getStreet());
        existentProperty.setAddressNumber(property.getAddressNumber());
        existentProperty.setCategory(property.getCategory());
        existentProperty.setDescription(property.getDescription());
        existentProperty.setCharacteristics(property.getCharacteristics());
        existentProperty.setPrice(property.getPrice());
        existentProperty.setArea(property.getArea());
        existentProperty.setBathrooms(property.getBathrooms());
        existentProperty.setBedrooms(property.getBedrooms());
        existentProperty.setCarsQuantity(property.getCarsQuantity());
        existentProperty.setImages(property.getImages());

        propertyRepository.save(existentProperty);
    }

    public void deleteProperty(Long propertyId) throws br.com.realestate.errors.PropertyNotFoundException {
        Property existentProperty = findByPropertyId(propertyId);
        propertyRepository.delete(existentProperty);
    }
}
