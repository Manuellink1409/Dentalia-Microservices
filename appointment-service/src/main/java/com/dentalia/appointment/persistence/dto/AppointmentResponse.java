package com.dentalia.appointment.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AppointmentResponse {

    private Long id;
    private Long patientId;
    private LocalDate date;
    private LocalTime hour;
    private String isConfirmed;
    private String isActive;

}
