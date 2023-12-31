package br.com.realstate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.realstate.model.Property;
import br.com.realstate.repository.PropertyRepository;
import jakarta.el.PropertyNotFoundException;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public void saveProperty(Property property) {
        if (propertyRepository.findByPropertyId(property.getPropertyId()).isPresent()) {
            throw new RuntimeException(property.getPropertyId() + " already exists");
        }
        property.setPropertyId(property.getCep().toString() + property.getAddressNumber().toString());
        propertyRepository.save(property);
    }

    public Property findByPropertyId(String propertyId) {
        return propertyRepository.findByPropertyId(propertyId).orElseThrow(() -> new PropertyNotFoundException(propertyId));
    }

    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    public List<Property> findAllPropertiesByCategory(String category) {
        return propertyRepository.findAllByCategory(category);
    }

    public List<Property> findAllPropertiesByCep(Integer CEP) {
        return propertyRepository.findAllByCep(CEP);
    }

    public void updateProperty(String propertyId, Property property) {
        Property existentProperty = findByPropertyId(propertyId);

        existentProperty.setDescription(property.getDescription());
        existentProperty.setCharacteristics(property.getCharacteristics());
        existentProperty.setPrice(property.getPrice());
        existentProperty.setImages(property.getImages());

        propertyRepository.save(existentProperty);
    }

    public void deleteProperty(String propertyId) {
        Property existentProperty = findByPropertyId(propertyId);
        propertyRepository.delete(existentProperty);
    }
}
