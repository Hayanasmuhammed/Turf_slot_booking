package com.maracana.turf_slot_booking.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.maracana.turf_slot_booking.exception.BadRequestException;
import com.maracana.turf_slot_booking.model.LoginReq;
import com.maracana.turf_slot_booking.model.SignUpReq;
import com.maracana.turf_slot_booking.model.UserSignUp;
import com.maracana.turf_slot_booking.repository.UserSignUpRepository;

import jakarta.validation.Valid;

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

    public String login(Optional<LoginReq> req) {
        return req.map(loginReq -> {
            UserSignUp user = userSignUpRepository.findByEmailAndPassword(loginReq.getEmail(), loginReq.getPassword());
            if (user != null) {
                return "Login successful";
            } else {
                throw new BadRequestException("Invalid email or password");
            }
        }).orElseThrow(() -> new BadRequestException("Request is not present"));
    }

}
