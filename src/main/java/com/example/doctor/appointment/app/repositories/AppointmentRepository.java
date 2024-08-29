package com.example.doctor.appointment.app.repositories;

import com.example.doctor.appointment.app.domain.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {

}

