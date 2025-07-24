package com.maracana.turf_slot_booking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.maracana.turf_slot_booking.model.UserSignUp;

public interface UserSignUpRepository extends MongoRepository<UserSignUp, String> {

    @Query(value = "{ 'email' : ?0, 'password' : ?1 }")
    UserSignUp findByEmailAndPassword(String email, String password);

    @Query(value = "{ 'email' : ?0 }", exists = true)
    boolean existsByEmail(String email);

    @Query(value = "{ 'email' : ?0 }")
    List<UserSignUp> findByEmail(String email);

}
