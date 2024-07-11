package com.dentalia.patient.persistence.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientRequest {

    @NotBlank(message = "Firstname field can not be blank.")
    @NotNull(message = "Firstname field can not be null.")
    private String firstname;
    @NotBlank(message = "Lastname field can not be blank.")
    @NotNull(message = "Lastname field can not be null.")
    private String lastname;
    @Email(message = "Email isn't well formatted.")
    @NotBlank(message = "Email field can not be blank.")
    @NotNull(message = "Email field can not be null.")
    private String email;
    @NotBlank(message = "Phone field can not be blank.")
    @NotNull(message = "Phone field can not be null.")
    @Size(min = 10, max = 10)
    private String phone;

}
