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
public class AppointmentRequest {

    private Long patientId;
    private LocalDate date;
    private LocalTime hour;

}
