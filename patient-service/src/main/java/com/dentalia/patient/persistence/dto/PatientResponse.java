package com.dentalia.patient.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PatientResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String isActive;
}
