package com.maracana.turf_slot_booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.maracana.turf_slot_booking.model.UserSignUp;

public interface UserSignUpRepository extends MongoRepository<UserSignUp, String> {

    @Query(value = "{ 'email' : ?0, 'password' : ?1 }")
    UserSignUp findByEmailAndPassword(String email, String password);

    @Query(value = "{ 'email' : ?0 }", exists = true)
    boolean existsByEmail(String email);

}
