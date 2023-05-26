package com.example.authorization_service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthorizationServiceApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;
	
	private static final GenericContainer<?> myApp1 = new GenericContainer<>("capp:1.0")
			.withExposedPorts(8080);
	
	private static final GenericContainer<?> myApp2 = new GenericContainer<>("tcapp:latest")
			.withExposedPorts(8081);
	
	@BeforeAll
	public static void setUp() {
		myApp1.start();
		myApp2.start();
	}
	
	@Test
	void contextLoads() {
		ResponseEntity<String> forEntity1 = restTemplate.getForEntity("http://localhost:" + myApp1.getMappedPort(8080), String.class);
		System.out.println("First: " + forEntity1.getBody());
		
		ResponseEntity<String> forEntity2 = restTemplate.getForEntity("http://localhost:" + myApp2.getMappedPort(8081), String.class);
		System.out.println("Second: " + forEntity2.getBody());
	}
	
}
