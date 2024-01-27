package br.com.realestate.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.realestate.model.Admin;

// The code snippet is defining a repository interface called `AdminRepository` for the `Admin` model class.

@Repository
public interface AdminRepository extends MongoRepository<Admin, ObjectId> {
    Optional<Admin> findByEmail(String email);

    Optional<Admin> findByPhone(String phone);
}
