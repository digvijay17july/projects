package com.devOpsTool.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configurations {

    ToolConfiguration toolConfiguration;

    Configurations(ToolConfiguration toolConfiguration) {
        this.toolConfiguration = toolConfiguration;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
