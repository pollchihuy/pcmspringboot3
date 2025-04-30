package com.juarcoding.pcmspringboot3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class CobaController {

    @GetMapping("/lg")
    public String getData(){
        return "login";
    }
}
