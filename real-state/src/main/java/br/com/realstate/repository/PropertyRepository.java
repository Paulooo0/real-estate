package br.com.realstate.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.realstate.model.Property;

@Repository
public interface PropertyRepository extends MongoRepository<Property, ObjectId> {
    List<Property> findAllByCategory(String category);

    List<Property> findAllByCep(Integer CEP);


}
