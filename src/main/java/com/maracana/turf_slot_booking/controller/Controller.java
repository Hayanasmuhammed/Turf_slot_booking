package com.maracana.turf_slot_booking.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maracana.turf_slot_booking.model.LoginReq;
import com.maracana.turf_slot_booking.model.ResponseMessage;
import com.maracana.turf_slot_booking.model.SignUpReq;
import com.maracana.turf_slot_booking.service.TurfBookingService;

import jakarta.validation.Valid;

@RestController
public class Controller {

    @Autowired
    private TurfBookingService turfBookingService;

    // controller for signup
    @PostMapping("/v1/user/signup")
    public ResponseEntity<?> signupUserByEmail(@RequestBody @Valid Optional<SignUpReq> req) {
        String res = turfBookingService.signUp(req);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                .body(new ResponseMessage(res));
    }

    // login using email and password
    @PostMapping("/v1/user/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid Optional<LoginReq> req) {
        String res = turfBookingService.login(req);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                .body(new ResponseMessage(res));
    }

    // forgot password otp generation
    @GetMapping("/v1/email/{emailID}/forgot_password")
    public ResponseEntity<?> forgotPasswordOtpToMail(@PathVariable("emailID") String emailID) {
        String res = turfBookingService.forgotPasswordOtpToMail(emailID);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                .body(new ResponseMessage(res));
    }

}
