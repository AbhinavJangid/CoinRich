package com.coinrich.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Coinrich1Application {

	public static void main(String[] args) {
		SpringApplication.run(Coinrich1Application.class, args);
	}

}
