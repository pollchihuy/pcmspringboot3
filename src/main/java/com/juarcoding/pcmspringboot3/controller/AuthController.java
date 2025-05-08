package com.juarcoding.pcmspringboot3.controller;

import com.juarcoding.pcmspringboot3.dto.validation.LoginDTO;
import com.juarcoding.pcmspringboot3.dto.validation.RegisDTO;
import com.juarcoding.pcmspringboot3.dto.validation.VerifyRegisDTO;
import com.juarcoding.pcmspringboot3.model.User;
import com.juarcoding.pcmspringboot3.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    /**
     * 1. Registrasi
     * 2. Login
     * 3. Lupa Password
     */
    @Autowired
    AuthService authService;

    @PostMapping("/regis")
    public ResponseEntity<Object> registration(@Valid @RequestBody RegisDTO regisDTO){
        return authService.regis(authService.mapToUser(regisDTO));
    }

    @PostMapping("/verify-regis")
    public ResponseEntity<Object> verifyRegis(@Valid @RequestBody VerifyRegisDTO verifyRegisDTO){
        return authService.verifyRegis(authService.mapToUser(verifyRegisDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDTO loginDTO){
        return authService.login(authService.mapToUser(loginDTO));
    }
}