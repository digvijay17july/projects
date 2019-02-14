package com.pack.controller;

import com.pack.dto.UserDto;
import org.elasticsearch.usage.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/User")
public class UserControllerImpl implements UserController {
    @Autowired
    UsageService usageService;

    @Override
    public ResponseEntity<UserDto> register(@RequestParam(required = true) UserDto userDto) {
        return null;
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
}
