package com.service;

import com.dto.UserDto;
import com.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface PostService {
    Integer[] burstTime=new Integer[5];
 List<Map<UserEntity, String>> postData();
}
