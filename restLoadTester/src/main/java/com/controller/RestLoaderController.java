package com.controller;

import com.dto.UserDto;
import com.entity.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

public interface RestLoaderController {
    @RequestMapping(value = "/load", produces = "application/json", method = RequestMethod.GET)
    default ResponseEntity< List<Map<UserEntity, String>>> load() {
        return new ResponseEntity< List<Map<UserEntity, String>>>(HttpStatus.NOT_IMPLEMENTED);
    }
}
