package com.sanbro.Authentication.Repository;

import com.sanbro.Authentication.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SignUpRepository extends MongoRepository<User, ObjectId> {

    Optional<User> findByEmail(String email);
}
