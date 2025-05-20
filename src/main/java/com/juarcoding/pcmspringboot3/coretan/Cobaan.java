package com.juarcoding.pcmspringboot3.coretan;

import com.juarcoding.pcmspringboot3.utils.LoggingFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cobaan {


    public static void main(String[] args) {

//        try{
//            int i = 1/0;
//        }catch (Exception e){
//            LoggingFile.logException("Cobaan","main(String[] args)",e);
//        }
        String x = "code#poll.chihuy@gmail.com-08128601033-paul.1234#1928918450";
        String [] arr = x.split("#");

        String [] data = arr[1].split("-");
        for (String xData : data) {
            System.out.println(xData);
        }
    }
}
