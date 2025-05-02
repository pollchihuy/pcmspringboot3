package com.juarcoding.pcmspringboot3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author pollc a.k.a. Paul Christian
Java Developer
Created on 02/05/2025 19:27
@Last Modified 02/05/2025 19:27
Version 1.0
*/
@Configuration
@PropertySource("classpath:otherconfig.properties")
public class OtherConfig {

    private static String enableLogFile;

    public static String getEnableLogFile() {
        return enableLogFile;
    }

    @Value("${enable.log.file}")
    private void setEnableLogFile(String enableLogFile) {
        this.enableLogFile = enableLogFile;
    }
}
