package com.pack.service;

import com.pack.dto.UserDto;
import com.pack.entity.UserEntity;
import com.pack.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingUpServiceImpl implements SingUpService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity createUser(UserDto userDto) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userEntity, userDto);
        userEntity = userRepository.save(userEntity);
        return userEntity;
    }

    @Override
    public boolean login(UserDto userDto) {

        if (userRepository.findByUserId(userDto.getUserId()) != null) 
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
