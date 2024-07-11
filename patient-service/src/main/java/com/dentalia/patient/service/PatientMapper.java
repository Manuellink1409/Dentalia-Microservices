package com.dentalia.patient.service;

import com.dentalia.patient.persistence.dto.PatientRequest;
import com.dentalia.patient.persistence.dto.PatientResponse;
import com.dentalia.patient.persistence.enums.Status;
import com.dentalia.patient.persistence.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    public Patient toPatient(PatientRequest request) {
        return  Patient.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .phone(request.getPhone())
                .isActive(Status.ACTIVE)
                .build();
    }

    public PatientResponse toPatientResponse(Patient patient) {
        return PatientResponse.builder()
                .id(patient.getId())
                .firstname(patient.getFirstname())
                .lastname(patient.getLastname())
                .email(patient.getEmail())
                .phone(patient.getPhone())
                .isActive(patient.getIsActive().name())
                .build();
    }

    public Patient toPatientSave(PatientRequest request, Long id) {
        return  Patient.builder()
                .id(id)
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .phone(request.getPhone())
                .isActive(Status.ACTIVE)
                .build();
    }
}
