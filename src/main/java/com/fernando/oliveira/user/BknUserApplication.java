package com.fernando.oliveira.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BknUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(BknUserApplication.class, args);
	}

}
