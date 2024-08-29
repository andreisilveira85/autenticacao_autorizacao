package com.example.doctor.appointment.app.domain.user;

public enum UserRole {

    ADMIN("admin"),
    DOCTOR("doctor"),
    RECEPTIONIST("receptionist"),
    PATIENT("patient");

    private final String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }
}

