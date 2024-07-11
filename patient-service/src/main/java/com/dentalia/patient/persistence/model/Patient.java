package com.dentalia.patient.persistence.model;

import com.dentalia.patient.persistence.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient")
    private Long id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private String phone;
    @Column(name = "is_active")
    private Status isActive;

}
