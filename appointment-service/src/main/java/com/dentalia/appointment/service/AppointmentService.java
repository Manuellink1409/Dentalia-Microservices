package com.dentalia.appointment.service;

import com.dentalia.appointment.persistence.dto.AppointmentRequest;
import com.dentalia.appointment.persistence.dto.AppointmentResponse;
import com.dentalia.appointment.persistence.enums.Confirmed;
import com.dentalia.appointment.persistence.enums.Status;
import com.dentalia.appointment.persistence.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final CatalogPatientService catalogPatientService;

    public List<AppointmentResponse> findAllAppointments() {
        var listOfAppointments = appointmentRepository.findAll();
        return listOfAppointments.stream()
                .map(appointmentMapper::toAppointmentResponse)
                .toList();
    }

    public Long createAppointment(AppointmentRequest request) {
        boolean exists = catalogPatientService.patientExists(request.getPatientId());
        if (!exists) {
            throw new RuntimeException("Patient does not exist");
        }
        var appointment = appointmentMapper.toAppointment(request);
        return appointmentRepository.save(appointment).getId();
    }

    public Long updateAppointmentById(Long id, AppointmentRequest request) {
        var appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
        var updateAppointment = appointmentMapper.toAppointmentSave(request,appointment.getId());
        return appointmentRepository.save(updateAppointment).getId();
    }

    public Long disabledAppointmentById(Long id) {
        var appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
        appointment.setIsActive(Status.INACTIVE);
        return appointmentRepository.save(appointment).getId();
    }

    public Long confirmedAppointmentById(Long id) {
        var appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
        appointment.setIsConfirmed(Confirmed.IS_CONFIRMED);
        return appointmentRepository.save(appointment).getId();
    }
}
