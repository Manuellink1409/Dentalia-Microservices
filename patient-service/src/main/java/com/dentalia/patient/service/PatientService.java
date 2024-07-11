package com.dentalia.patient.service;

import com.dentalia.patient.persistence.dto.PatientPage;
import com.dentalia.patient.persistence.dto.PatientRequest;
import com.dentalia.patient.persistence.dto.PatientResponse;
import com.dentalia.patient.persistence.enums.Status;
import com.dentalia.patient.persistence.model.Patient;
import com.dentalia.patient.persistence.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;

    public Long createPatient(PatientRequest request) {
        var patient = patientMapper.toPatient(request);
        return patientRepository.save(patient).getId();
    }

    public PatientResponse findPatientById(Long id) {
        var patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        return patientMapper.toPatientResponse(patient);
    }

    public PatientPage<PatientResponse> findAllPatients(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Patient> pageOfPatients = patientRepository.findAll(pageable);
        List<PatientResponse> patientsList = pageOfPatients
                .stream()
                .map(patientMapper::toPatientResponse)
                .toList();
        return new PatientPage<>(
                patientsList,
                page,
                size,
                pageOfPatients.getNumber(),
                pageOfPatients.isFirst(),
                pageOfPatients.isLast()
        );
    }

    public Long disabledPatientById(Long id) {
        var patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        if (patient.getIsActive() == Status.INACTIVE){
            throw new RuntimeException("Patient is inactive");
        }
        patient.setIsActive(Status.INACTIVE);
        return patientRepository.save(patient).getId();
    }

    public boolean patientExists(Long id) {
        return patientRepository.existsByIdAndIsActive(id, Status.ACTIVE);
    }

    public Long updatePatientById(Long id, PatientRequest request) {
        var patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        var updatedPatient = patientMapper.toPatientSave(request,patient.getId());
        return patientRepository.save(updatedPatient).getId();
    }
}
