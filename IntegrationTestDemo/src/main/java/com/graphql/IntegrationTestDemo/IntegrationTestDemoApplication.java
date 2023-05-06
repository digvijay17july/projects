package com.graphql.IntegrationTestDemo;

import graphql.scalars.ExtendedScalars;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntegrationTestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationTestDemoApplication.class, args);
	}
	@Bean
	public graphql.schema.GraphQLScalarType UUID() {
		return ExtendedScalars.UUID;
	}
}
