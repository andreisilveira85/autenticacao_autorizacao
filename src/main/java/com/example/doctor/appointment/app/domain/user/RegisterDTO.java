package com.example.doctor.appointment.app.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
