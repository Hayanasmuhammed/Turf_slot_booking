package com.maracana.turf_slot_booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.maracana.turf_slot_booking.model.UserOTP;

public interface OtpRepository extends MongoRepository<UserOTP, String> {

}
