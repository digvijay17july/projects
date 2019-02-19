package com.service;

import com.dto.UserDto;
import com.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        ScheduledFuture future = null;
        List<Future> taskList = new ArrayList<Future>();

        for (UserDto userDto : userDtos) {
            future=executor.schedule(new MultiUserRegiserServiceImpl(userDto,restTemplate), 1, TimeUnit.SECONDS);
            taskList.add(future);
        }
        executor.shutdown();
        ResponseEntity<UserDto> responseEntity=null;
        Map tempMap=null;
        for (Future futureValue : taskList
        ) {
            try {
                responseEntity=(ResponseEntity<UserDto>)futureValue.get();
                tempMap=new HashMap<>();
                tempMap.put(responseEntity.getBody(),responseEntity.getStatusCode());
                maps.add(tempMap);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
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
