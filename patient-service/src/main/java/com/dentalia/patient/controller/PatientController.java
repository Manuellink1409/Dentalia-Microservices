package com.dentalia.patient.controller;

import com.dentalia.patient.persistence.dto.PatientPage;
import com.dentalia.patient.persistence.dto.PatientRequest;
import com.dentalia.patient.persistence.dto.PatientResponse;
import com.dentalia.patient.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    public final PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> findPatientById
            (@PathVariable Long id) {
        return ResponseEntity.ok(patientService.findPatientById(id));
    }

    @GetMapping
    public ResponseEntity<PatientPage<PatientResponse>> findAllPatients
            (@RequestParam(defaultValue = "10", required = false) int size,
             @RequestParam(defaultValue = "0", required = false) int page) {
        return ResponseEntity.ok(patientService.findAllPatients(size, page));
    }

    @PostMapping
    public ResponseEntity<Long> createPatient
    (@Valid @RequestBody PatientRequest request) {
        return ResponseEntity.ok(patientService.createPatient(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updatePatientById(
            @PathVariable Long id,
            @Valid @RequestBody PatientRequest request) {
        return ResponseEntity.ok(patientService.updatePatientById(id, request));
    }

    @PatchMapping("/{id}/disabled")
    public ResponseEntity<Long> disabledPatientById(
            @PathVariable Long id) {
        return ResponseEntity.ok(patientService.disabledPatientById(id));
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> patientExists
            (@PathVariable Long id) {
        return ResponseEntity.ok(patientService.patientExists(id));
    }
}
