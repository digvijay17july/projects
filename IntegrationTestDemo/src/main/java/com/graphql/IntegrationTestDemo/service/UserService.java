package com.graphql.IntegrationTestDemo.service;

import com.graphql.IntegrationTestDemo.models.User;

import java.util.List;

/*
 * @project IntegrationTestDemo
 * @author Digvijay Singh
 */
public interface UserService {

    List<User> getAllUsers();
}
