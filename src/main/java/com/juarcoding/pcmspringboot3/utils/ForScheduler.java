package com.juarcoding.pcmspringboot3.utils;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author pollc a.k.a. Paul Christian
Java Developer
Created on 02/05/2025 19:07
@Last Modified 02/05/2025 19:07
Version 1.0
*/
@Component
public class ForScheduler {


//    @Scheduled(fixedRate = 5000)
//    public void printOK(){
//        System.out.println("OK DEH !!");
//    }

    @Scheduled(cron = "0 0 19 11 * *")
    public void printDeh(){
        System.out.println("OK DEH 111 !!");
    }

    @Async
    public void sampleAsync(){
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println("Detik ke !!"+(i+1));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
