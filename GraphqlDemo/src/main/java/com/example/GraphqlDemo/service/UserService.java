package com.example.GraphqlDemo.service;

import com.example.GraphqlDemo.model.User;

import java.util.List;
import java.util.UUID;

/*
 * @project GraphqlDemo
 * @author Digvijay Singh
 */
public interface UserService {

    User save(User user)throws Exception;
    Boolean update(User user) throws Exception;
    Boolean delete(UUID userId) throws Exception;
    User get(UUID userId) throws Exception;
    List<User> getAll()throws Exception;
}
