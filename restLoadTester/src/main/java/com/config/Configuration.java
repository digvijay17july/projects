package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Configuration {

    @Bean("restTemplate")
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
