package com.juarcoding.pcmspringboot3.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Random;

@Configuration
public class AllConfig {

    @Bean
    public Random getRandom(){
        return new Random();
    }
}
