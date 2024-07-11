package com.dentalia.appointment.service;

import com.dentalia.appointment.persistence.dto.AppointmentRequest;
import com.dentalia.appointment.persistence.dto.AppointmentResponse;
import com.dentalia.appointment.persistence.enums.Confirmed;
import com.dentalia.appointment.persistence.enums.Status;
import com.dentalia.appointment.persistence.model.Appointment;
import org.springframework.stereotype.Service;

@Service
public class AppointmentMapper {


    public AppointmentResponse toAppointmentResponse(Appointment appointment) {
        return AppointmentResponse.builder()
                .id(appointment.getId())
                .patientId(appointment.getPatientId())
                .date(appointment.getDate())
                .hour(appointment.getHour())
                .isConfirmed(appointment.getIsConfirmed().name())
                .isActive(appointment.getIsActive().name())
                .build();
    }

    public Appointment toAppointment(AppointmentRequest request) {
        return Appointment.builder()
                .patientId(request.getPatientId())
                .date(request.getDate())
                .hour(request.getHour())
                .isConfirmed(Confirmed.IS_NOT_CONFIRMED)
                .isActive(Status.ACTIVE)
                .build();
    }

    public Appointment toAppointmentSave(AppointmentRequest request, Long id) {
        return Appointment.builder()
                .id(id)
                .patientId(request.getPatientId())
                .date(request.getDate())
                .hour(request.getHour())
                .isConfirmed(Confirmed.IS_NOT_CONFIRMED)
                .isActive(Status.ACTIVE)
                .build();
    }
}
