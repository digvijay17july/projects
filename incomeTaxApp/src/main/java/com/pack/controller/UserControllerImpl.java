package com.pack.controller;

import com.pack.dto.UserDto;
import com.pack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("v1/user")
public class UserControllerImpl implements UserController {
    @Autowired
    UserService userService;

    static int i = 0;

    @Override

    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        userDto = userService.createUser(userDto);
        System.out.println("***" + userDto.toString());
        if (i < 12001) {
            i++;
            return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
        } else {
            i = 0;
            return new ResponseEntity<UserDto>(userDto, HttpStatus.TOO_MANY_REQUESTS);
        }
    }

    @Override
    public ResponseEntity<UserDto> delete(String userDto) {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> update(UserDto userDto) {
        return null;
    }

    @Override
    public ResponseEntity<UserDto> getDetails(UserDto userDto) {
        return null;
    }

    @RequestMapping(value = "/", produces = "application/json", method = RequestMethod.GET)
    String getDetail() {
        return "hello";
    }
}
