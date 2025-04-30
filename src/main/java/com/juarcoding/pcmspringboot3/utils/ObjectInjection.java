package com.juarcoding.pcmspringboot3.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author pollc a.k.a. Paul Christian
Java Developer
Created on 30/04/2025 19:56
@Last Modified 30/04/2025 19:56
Version 1.0
*/
@Component
public class ObjectInjection {

    @Deprecated
    private String x;


    public ObjectInjection() {
    }


    @Deprecated(forRemoval = true)
    public void printText(){
        String z = "";
    //OWASP
        System.out.println("HUE");
    }


}
