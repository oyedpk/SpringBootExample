package com.rest.example.restexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestexampleApplication.class, args);
	}

}
