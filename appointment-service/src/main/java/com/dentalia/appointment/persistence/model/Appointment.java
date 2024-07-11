package com.dentalia.appointment.persistence.model;

import com.dentalia.appointment.persistence.enums.Confirmed;
import com.dentalia.appointment.persistence.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_appointment")
    private Long id;
    @Column(name = "id_patient")
    private Long patientId;
    private LocalDate date;
    private LocalTime hour;
    private Confirmed isConfirmed;
    @Column(name = "is_active")
    @Enumerated(EnumType.STRING)
    private Status isActive;

}
