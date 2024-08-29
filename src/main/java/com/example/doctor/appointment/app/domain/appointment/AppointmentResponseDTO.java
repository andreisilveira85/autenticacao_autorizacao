package com.example.doctor.appointment.app.domain.appointment;

import java.time.LocalDateTime;

public record AppointmentResponseDTO(String id, LocalDateTime dateTime, String reason) {
    public AppointmentResponseDTO(Appointment appointment) {
        this(appointment.getId(), appointment.getDateTime(), appointment.getReason());
    }
}


