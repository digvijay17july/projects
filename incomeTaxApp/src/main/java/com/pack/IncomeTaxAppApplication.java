package com.pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class IncomeTaxAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncomeTaxAppApplication.class, args);
	}

}

