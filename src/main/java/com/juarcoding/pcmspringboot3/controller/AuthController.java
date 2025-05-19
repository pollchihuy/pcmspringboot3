package com.juarcoding.pcmspringboot3.controller;

import com.juarcoding.pcmspringboot3.dto.validation.LoginDTO;
import com.juarcoding.pcmspringboot3.dto.validation.RegisDTO;
import com.juarcoding.pcmspringboot3.dto.validation.VerifyRegisDTO;
import com.juarcoding.pcmspringboot3.service.AuthService;
import com.juarcoding.pcmspringboot3.utils.GlobalFunction;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<Object> registration(@Valid @RequestBody RegisDTO regisDTO
            , HttpServletRequest request

    ){
        return authService.regis(authService.mapToUser(regisDTO),request);
    }

    @PostMapping("/verify-regis")
    public ResponseEntity<Object> verifyRegis(@Valid @RequestBody VerifyRegisDTO verifyRegisDTO
            , HttpServletRequest request){
        return authService.verifyRegis(authService.mapToUser(verifyRegisDTO),request);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDTO loginDTO
            , HttpServletRequest request){

//        GlobalFunction.printConsole("Username  : "+loginDTO.getUsername());
//        GlobalFunction.printConsole("Password  : "+loginDTO.getPassword());
        return authService.login(authService.mapToUser(loginDTO),request);
    }
}