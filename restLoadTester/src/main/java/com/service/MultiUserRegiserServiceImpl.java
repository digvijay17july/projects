package com.service;

import com.dto.UserDto;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class MultiUserRegiserServiceImpl implements MultiUserRegiserService {
    private RestTemplate restTemplate;
    private UserDto userDto;

    public MultiUserRegiserServiceImpl(UserDto userDto, RestTemplate restTemplate) {
        this.userDto = userDto;
        this.restTemplate = restTemplate;
    }

    public MultiUserRegiserServiceImpl() {
    }

    @Override
    public ResponseEntity<UserDto> call() throws Exception {
        ResponseEntity<UserDto> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange("http://localhost:9191/api/v1/user/registerUser", HttpMethod.POST,
                    new HttpEntity<>(userDto, new HttpHeaders()), UserDto.class);
        } catch (HttpClientErrorException httpClientErrorException) {
            System.out.println("Working fine " + httpClientErrorException);
            restTemplate = new RestTemplate();
            responseEntity = restTemplate.exchange("http://localhost:9191/api/v1/user/registerUser", HttpMethod.POST,
                    new HttpEntity<>(userDto, new HttpHeaders()), UserDto.class);
        }

        return responseEntity;
    }
}
