package com.juarcoding.pcmspringboot3.coretan;

import com.juarcoding.pcmspringboot3.utils.ObjectInjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author pollc a.k.a. Paul Christian
Java Developer
Created on 29/04/2025 20:09
@Last Modified 29/04/2025 20:09
Version 1.0
*/
@Component
public class Cobain {

//    @Autowired
//    ObjectInjection oi ;
//
//    @Autowired
//    Random rand ;

    public static void main(String[] args) {
//        String strX = "2#poll.chihuy@gmail.com#0856123131#1745932162860";
//        String [] strArr = strX.split("#");
//        for (String str : strArr) {
//            System.out.println(str);
//        }
//        System.out.println(System.currentTimeMillis());
        ObjectInjection oi = new ObjectInjection();
        oi.printText();
    }
}
