package com.juarcoding.pcmspringboot3.coretan;

import com.juarcoding.pcmspringboot3.security.Crypto;
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
//        ObjectInjection oi = new ObjectInjection();
//        oi.printText();
//jahfdsijgbsidjb$]9ogoakspdok0817972y4987364$91287234675
//        System.out.println("NyamNyam".contains("$]9o"));

//        System.out.println("\\\\");
//        System.out.println("$2a$11$nyjU3om84Gp6S6sv.n2KXOMo.BDfKo9buGQ.u8FDaEhWI4X5GNX7W".equals("$2a$11$RBDOEJ1RX14vzySpUAJnqeKoEJ3jvJK9ip./tCJquboLW.NHD14l."));

        System.out.println("Ini Username : "+Crypto.performDecrypt("552d01ab11300b7f496bbf71baf6a8c7"));
        System.out.println("Ini Password : "+Crypto.performDecrypt("39360fd6f563c8b6a95277e439563596"));
        System.out.println(Crypto.performEncrypt("isi text nya !!"));

        System.out.println(System.currentTimeMillis());
        System.out.println(Crypto.performEncrypt("CD#poll@gmail.com#1746457081029"));
        System.out.println(Crypto.performDecrypt("3124a67f19e80d187e5e58d24910d646895e5c69a5336e8173b89f8ef9749736"));
        String [] strArr = Crypto.performDecrypt("3124a67f19e80d187e5e58d24910d646895e5c69a5336e8173b89f8ef9749736").split("#");
        Long time = Long.parseLong(strArr[2]);
        Long now = System.currentTimeMillis();
        System.out.println(((now-time)/1000)<300);
    }
}
