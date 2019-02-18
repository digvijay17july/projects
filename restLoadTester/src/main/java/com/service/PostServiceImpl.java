package com.service;

import com.dto.UserDto;
import com.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Map<UserEntity, String>> postData() {
        List<Map<UserEntity, String>> maps = new ArrayList<>();
        List<UserDto> userDtos = getUserList();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<FutureTask> taskList = new ArrayList<FutureTask>();
        Future future=new FutureTask<ResponseEntity<UserDto>>(new Callable<ResponseEntity<UserDto>>() {
            @Override
            public ResponseEntity<UserDto> call() throws Exception {
                ResponseEntity<UserDto> responseEntity = restTemplate.exchange("http://localhost:9191/api/v1/user/registerUser", HttpMethod.POST,
                        new HttpEntity<>(userDto, new HttpHeaders()), UserDto.class);

                return null;
            }
        });


        return maps;
    }

    private List<UserDto> getUserList() {
        List<UserDto> userDtoList = new ArrayList<UserDto>();
        UserDto userDto;

        for (int i = 0; i < 150000; i++) {
            userDto = new UserDto();
            userDto.setActive(true);
            userDto.setAddress("GHAZIABAD" + i);
            userDto.setAge(i);
            userDto.setGrossSalary(new Double(i));
            userDto.setFirstName("Ankit" + i);
            userDto.setLastName("agarwal" + i);
            userDto.setMobileNo("965093860" + i);
            userDto.setPassword("digvijay" + i);
            userDto.setUsername("ankit" + i);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
}
