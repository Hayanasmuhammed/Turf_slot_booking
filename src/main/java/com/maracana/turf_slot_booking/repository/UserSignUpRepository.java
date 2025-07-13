package com.maracana.turf_slot_booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.maracana.turf_slot_booking.model.UserSignUp;

public interface UserSignUpRepository extends MongoRepository<UserSignUp, String> {
    // Define custom query methods if needed

}
