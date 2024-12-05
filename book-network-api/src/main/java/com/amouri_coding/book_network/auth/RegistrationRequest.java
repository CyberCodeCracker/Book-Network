package com.amouri_coding.book_network.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotBlank(message = "Firstname is obligatory")
    private String firstName;
    @NotBlank(message = "Lastname is obligatory")
    private String lastName;
    @Column(unique = true)
    @NotBlank(message = "Email is obligatory")
    @Email(message = "Email is not well formatted")
    private String email;
    @NotBlank(message = "Password is obligatory")
    @Size(min = 8, max = 20, message = "Password should be between 8 and 20 characters long")
    private String password;

}