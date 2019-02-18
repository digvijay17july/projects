package com.controller;

import com.entity.UserEntity;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/loader")
public class RestLoaderControllerImpl implements RestLoaderController {

    @Autowired
    PostService postService;
    @Override
    public ResponseEntity< List<Map<UserEntity, String>>> load() {

        return new ResponseEntity< List<Map<UserEntity, String>>>(postService.postData(),new HttpHeaders(), HttpStatus.OK);
    }
}
