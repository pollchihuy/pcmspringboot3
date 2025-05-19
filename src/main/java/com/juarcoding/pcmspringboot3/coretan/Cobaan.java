package com.juarcoding.pcmspringboot3.coretan;

import com.juarcoding.pcmspringboot3.utils.LoggingFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cobaan {


    public static void main(String[] args) {

        try{
            int i = 1/0;
        }catch (Exception e){
            LoggingFile.logException("Cobaan","main(String[] args)",e);
        }
    }
}
