package com.dentalia.appointment.persistence.repository;

import com.dentalia.appointment.persistence.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

}
