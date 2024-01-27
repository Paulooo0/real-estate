package br.com.realestate.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.realestate.model.Property;

// The code is defining a repository interface called `PropertyRepository` that extends the
// `MongoRepository` interface.

@Repository
public interface PropertyRepository extends MongoRepository<Property, ObjectId> {
    
    Optional<Property> findByPropertyId(Long propertyId);

    List<Property> findAllByCategory(String category);

    List<Property> findAllByCep(String CEP);
}
