package br.com.realstate.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.realstate.errors.PropertyAlreadyExistsException;
import br.com.realstate.model.Property;
import br.com.realstate.service.PropertyService;

@RestController
@RequestMapping("/property")
public class PropertyController {
    
    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public ResponseEntity<Property> saveProperty(@RequestBody Property property) throws PropertyAlreadyExistsException {
        propertyService.saveProperty(property);
        return ResponseEntity.status(HttpStatus.CREATED).body(property);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Property>> getAllProperties() {
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.findAll());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Property>> getAllPropertiesByCategory(@PathVariable String category) {
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.findAllPropertiesByCategory(category));
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<List<Property>> getAllPropertiesByCep(@PathVariable Long cep) {
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.findAllPropertiesByCep(cep));
    }

    @PutMapping("/update/{propertyId}")
    public ResponseEntity<String> updateProperty(@PathVariable String propertyId, @RequestBody Property property) {
        propertyService.updateProperty(propertyId, property);
        return ResponseEntity.status(HttpStatus.OK).body("Property with id " + propertyId + " was updated");
    }

    @DeleteMapping("/delete/{propertyId}")
    public ResponseEntity<String> deleteProperty(@PathVariable String propertyId) {
        propertyService.deleteProperty(propertyId);
        return ResponseEntity.status(HttpStatus.OK).body("Property with id " + propertyId + " was deleted");
    }
}
