package com.service;

import com.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MultiUserRegiserServiceImpl implements MultiUserRegiserService {
    private RestTemplate restTemplate;
    private UserDto userDto;

    public MultiUserRegiserServiceImpl(UserDto userDto,RestTemplate restTemplate) {
        this.userDto = userDto;
        this.restTemplate=restTemplate;
    }

    public MultiUserRegiserServiceImpl() {
    }

    @Override
    public ResponseEntity<UserDto> call() throws Exception {
        ResponseEntity<UserDto> responseEntity = restTemplate.exchange("http://localhost:9191/api/v1/user/registerUser", HttpMethod.POST,
                new HttpEntity<>(userDto, new HttpHeaders()), UserDto.class);
        return responseEntity;
    }
}
