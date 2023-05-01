package com.example.authorization_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.authorization_service.repository.UserRepository.initRegister;

@SpringBootApplication
public class AuthorizationServiceApplication {

	public static void main(String[] args) {
		initRegister();
		SpringApplication.run(AuthorizationServiceApplication.class, args);
	}

}
