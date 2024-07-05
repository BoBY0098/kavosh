package com.example.kavosh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class KavoshApplication {

	public static void main(String[] args) {
		SpringApplication.run(KavoshApplication.class, args);
	}

}
