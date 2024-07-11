package com.dentalia.appointment.controller;

import com.dentalia.appointment.persistence.dto.AppointmentRequest;
import com.dentalia.appointment.persistence.dto.AppointmentResponse;
import com.dentalia.appointment.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;


    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> findAllAppointments() {
        return ResponseEntity.ok(appointmentService.findAllAppointments());
    }

    @PostMapping
    public ResponseEntity<Long> createAppointment
    (@Valid @RequestBody AppointmentRequest request) {
        return ResponseEntity.ok(appointmentService.createAppointment(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateAppointmentById(
            @PathVariable Long id,
            @Valid @RequestBody AppointmentRequest request) {
        return ResponseEntity.ok(appointmentService.updateAppointmentById(id, request));
    }

    @PatchMapping("/{id}/disabled")
    public ResponseEntity<Long> disabledAppointmentById(
            @PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.disabledAppointmentById(id));
    }

    @PatchMapping("/{id}/confirmed")
    public ResponseEntity<Long> confirmedAppointmentById(
            @PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.confirmedAppointmentById(id));
    }

}
