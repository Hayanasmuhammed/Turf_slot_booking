package com.maracana.turf_slot_booking.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.maracana.turf_slot_booking.exception.BadRequestException;
import com.maracana.turf_slot_booking.model.SignUpReq;
import com.maracana.turf_slot_booking.model.UserSignUp;
import com.maracana.turf_slot_booking.repository.UserSignUpRepository;

@Service
public class TurfBookingService {

    @Autowired
    private UserSignUpRepository userSignUpRepository;

    public String signUp(Optional<SignUpReq> req) {
        if (!req.isPresent()) {
            throw new BadRequestException("Request is not present");
        }
        SignUpReq signUpReq = req.get();
        UUID uuid = UUID.randomUUID();
        UserSignUp userSignUp = new UserSignUp(uuid.toString(), signUpReq.getName(), signUpReq.getEmail(),
                signUpReq.getPassword());
        userSignUpRepository.save(userSignUp);
        return "Signup successfully";
    }

}
