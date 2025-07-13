package com.maracana.turf_slot_booking.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SignUpReq {
    @NotBlank(message = "Name required")
    private String name;
    @NotBlank(message = "Email required")
    private String email;
    @NotBlank(message = "Password required")
    private String password;

}
