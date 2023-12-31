package br.com.realstate.service;

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
        propertyRepository.save(property);
    }

    public Property findByPropertyId(String propertyId) {
        return propertyRepository.findByPropertyId(propertyId).orElseThrow(() -> new PropertyNotFoundException(propertyId));
    }
}
