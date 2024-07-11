package com.dentalia.patient.persistence.repository;

import com.dentalia.patient.persistence.enums.Status;
import com.dentalia.patient.persistence.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    boolean existsByIdAndIsActive(Long id, Status status);

}
