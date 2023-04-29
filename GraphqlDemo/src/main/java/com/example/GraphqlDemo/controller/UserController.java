package com.example.GraphqlDemo.controller;

import com.example.GraphqlDemo.model.User;
import com.example.GraphqlDemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;


/*
 * @project GraphqlDemo
 * @author Digvijay Singh
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @MutationMapping
    public User createUser(@Argument User user) {
        LOGGER.info("Entering the create user method to create user");

        try {
            user=userService.save(user);
            LOGGER.info("Successfully created user with id {}", user.getId());

        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        LOGGER.info("Returning the final response from create user method");
        return user;
    }

    @QueryMapping
    public User getUser(@Argument UUID userId) {
        LOGGER.info("Entering the get user method with id : {}", userId);
        User user = null;
        try {
            user = userService.get(userId);
            LOGGER.info("Successfully fetched the user with id {}", user.getId());
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        LOGGER.info("Returning the final response from get user method");
        return user;
    }

    @QueryMapping
    public List<User> getAllUsers() {
        LOGGER.info("Entering the get all users method");
        List<User> users = null;
        try {
            users = userService.getAll();
            LOGGER.info("Successfully fetched all users");
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        LOGGER.info("Returning the final response from get all users method");
        return users;
    }

    @MutationMapping
    Boolean updateUser(@Argument User user) {
        LOGGER.info("Entering the update user method to update user");
        Boolean response = Boolean.FALSE;
        try {
            response = userService.update(user);
            LOGGER.info("Successfully updated user with id {}", user.getId());
            response = Boolean.TRUE;
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        LOGGER.info("Returning the final response from update user method");
        return response;
    }

    @MutationMapping
    public Boolean deleteUser(@Argument UUID userId) {
        LOGGER.info("Entering the delete user method with id : {}", userId);
        Boolean response = null;
        try {
            response = userService.delete(userId);
            LOGGER.info("Successfully deleted the user with id {}", userId);
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        LOGGER.info("Returning the final response from delete user method");
        return response;
    }
}
