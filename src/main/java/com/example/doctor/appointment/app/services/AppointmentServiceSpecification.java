package com.example.doctor.appointment.app.services;

import com.example.doctor.appointment.app.domain.appointment.Appointment;
import com.example.doctor.appointment.app.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceSpecification {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }
}
