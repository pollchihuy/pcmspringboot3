package com.juarcoding.pcmspringboot3.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MainConfig {



    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
