package com.pack.service;

import com.pack.dto.UserDto;
import com.pack.entity.UserEntity;

interface SingUpService {

UserEntity createUser(final UserDto userDto);

boolean login(UserDto userDto);
}
