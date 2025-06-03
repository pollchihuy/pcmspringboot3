package com.juarcoding.pcmspringboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class Pcmspringboot3Application {
	public static void main(String[] args) {
		SpringApplication.run(Pcmspringboot3Application.class, args);
	}
}