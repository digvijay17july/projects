package com.service;

import com.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.Callable;

public interface MultiUserRegiserService extends Callable<ResponseEntity<UserDto>>  {
}
