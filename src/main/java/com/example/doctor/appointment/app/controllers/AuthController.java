package com.example.doctor.appointment.app.controllers;

import com.example.doctor.appointment.app.domain.user.AuthDTO;
import com.example.doctor.appointment.app.domain.user.LoginResponseDTO;
import com.example.doctor.appointment.app.domain.user.RegisterDTO;
import com.example.doctor.appointment.app.domain.user.User;
import com.example.doctor.appointment.app.infra.security.TokenService;
import com.example.doctor.appointment.app.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth =  this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.gerenateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid RegisterDTO data){
        if(this.userRepository.findByLogin(data.login()) != null ) return ResponseEntity.badRequest().build();

        String ecryptedPassword =  new BCryptPasswordEncoder().encode(data.password());

        this.userRepository.save(new User(data.login(), ecryptedPassword, data.role()));

        return ResponseEntity.ok().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();

        return ResponseEntity.ok().build();
    }

}
