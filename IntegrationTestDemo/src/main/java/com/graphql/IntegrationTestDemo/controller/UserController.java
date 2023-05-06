package com.graphql.IntegrationTestDemo.controller;

import com.graphql.IntegrationTestDemo.models.User;
import com.graphql.IntegrationTestDemo.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @project IntegrationTestDemo
 * @author Digvijay Singh
 */
@Component
public class UserController implements GraphQLQueryResolver {

@Autowired
    UserService userService;
    public List<User> getUsers(){
        List<User> users=userService.getAllUsers();

        return users;
    }
}
