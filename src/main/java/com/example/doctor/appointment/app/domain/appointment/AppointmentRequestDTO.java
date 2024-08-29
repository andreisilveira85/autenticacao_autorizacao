package com.example.doctor.appointment.app.domain.appointment;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record AppointmentRequestDTO(
        LocalDateTime dateTime,

        @NotBlank
        String reason
) {

}
