package com.pack.controller;

import com.pack.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UserController {
    @RequestMapping(value = "registerUser", produces = "application/json", method = RequestMethod.POST)
    default ResponseEntity<UserDto> register(UserDto userDto) {
        return new ResponseEntity<UserDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "deleteUser", produces = "application/json", method = RequestMethod.DELETE)
    default ResponseEntity<UserDto> delete(String userDto) {
        return new ResponseEntity<UserDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "updateUser", produces = "application/json", method = RequestMethod.PUT)
    default ResponseEntity<UserDto> update(UserDto userDto) {
        return new ResponseEntity<UserDto>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "userDetails", produces = "application/json", method = RequestMethod.GET)
    default ResponseEntity<UserDto> getDetails(UserDto userDto) {
        return new ResponseEntity<UserDto>(HttpStatus.NOT_IMPLEMENTED);
    }
}
