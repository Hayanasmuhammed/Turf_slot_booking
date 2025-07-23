package com.maracana.turf_slot_booking.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maracana.turf_slot_booking.exception.BadRequestException;
import com.maracana.turf_slot_booking.model.LoginReq;
import com.maracana.turf_slot_booking.model.SignUpReq;
import com.maracana.turf_slot_booking.model.UserSignUp;
import com.maracana.turf_slot_booking.repository.UserSignUpRepository;

@Service
public class TurfBookingService {

    @Autowired
    private UserSignUpRepository userSignUpRepository;

    @Autowired
    private EmailService emailService;

    public String signUp(Optional<SignUpReq> req) {
        if (!req.isPresent()) {
            throw new BadRequestException("Request is not present");
        }
        SignUpReq signUpReq = req.get();
        if (userSignUpRepository.existsByEmail(signUpReq.getEmail())) {
            throw new BadRequestException("Already registerd");
        }
        UUID uuid = UUID.randomUUID();
        UserSignUp userSignUp = new UserSignUp(uuid.toString(), signUpReq.getName(), signUpReq.getEmail(),
                signUpReq.getPassword());
        userSignUpRepository.save(userSignUp);

        // send email
        StringBuilder emailBody = new StringBuilder();

        emailBody.append("Hi ").append(userSignUp.getName()).append(",\n\n");
        emailBody.append("Welcome to Maraccana Turf! 🎉\n\n");

        emailBody.append(
                "We're excited to have you on board. Whether you're into football, cricket, badminton, tennis, or volleyball – we've got the perfect slot waiting for you.\n\n");

        emailBody.append("You can now:\n");
        emailBody.append("✅ Book turf slots easily\n");
        emailBody.append("✅ Manage your game schedule\n");
        emailBody.append("✅ Explore exciting offers and events\n\n");

        // emailBody.append("👉 Login now and start booking:
        // https://maraccana.in/login\n\n");

        emailBody.append(
                "If you have any questions or need help, just reply to this email or contact our support team.\n\n");

        emailBody.append("Let the games begin!\n");
        emailBody.append("Team Maraccana Turf");
        emailService.sendSimpleEmail(userSignUp.getEmail(), "Signup Successfully", emailBody.toString());

        return "Signup successfully";
    }

    public String login(Optional<LoginReq> req) {
        return req.map(loginReq -> {
            UserSignUp user = userSignUpRepository.findByEmailAndPassword(loginReq.getEmail(), loginReq.getPassword());
            if (user != null) {
                return "Login successfully for user: " + user.getName();
            } else {
                throw new BadRequestException("Invalid email or password");
            }
        }).orElseThrow(() -> new BadRequestException("Request is not present"));
    }

}
