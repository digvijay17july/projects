package com.pack.service;

import com.pack.dto.UserDto;
import com.pack.entity.UserEntity;

import java.util.Random;

public interface UserService {

    UserDto createUser(final UserDto userDto);

    boolean login(String username, String password);

    boolean isUserIdExists(Long _id);

    UserEntity fetchUserDetails(Long _id) throws Exception;

    default Long generateId() {
        Random random = new Random();
        Long id = Math.abs(random.nextLong());
        return id;
    }
}
