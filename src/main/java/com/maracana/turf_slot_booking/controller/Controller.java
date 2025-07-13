package com.maracana.turf_slot_booking.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maracana.turf_slot_booking.model.SignUpReq;
import com.maracana.turf_slot_booking.service.TurfBookingService;

import jakarta.validation.Valid;

@RestController
public class Controller {

    @Autowired
    private TurfBookingService turfBookingService;

    // controller for signup using email
    @PostMapping("/v1/user/signup")
    public String signupUserByEmail(@RequestBody @Valid Optional<SignUpReq> req) {
        String res = turfBookingService.signUp(req);
        return res;
    }

}
