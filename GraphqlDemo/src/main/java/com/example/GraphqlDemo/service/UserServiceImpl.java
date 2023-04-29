package com.example.GraphqlDemo.service;

import com.example.GraphqlDemo.model.User;
import com.example.GraphqlDemo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*
 * @project GraphqlDemo
 * @author Digvijay Singh
 */
@Service
public class UserServiceImpl implements UserService {

    private static Logger LOGGER= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @SchemaMapping
    @Override
    public User save(User user) throws Exception {
        LOGGER.info("Entered the save user method in user service");
        user = userRepository.save(user);
        if (user == null) {
            LOGGER.error("Error in creating the user");
            throw new Exception("Error in creating the user");
        }
        LOGGER.info("Exiting the save user method in user service");
        return  user;
    }

    @SchemaMapping
    @Override
    public Boolean update(User user) throws Exception {
        LOGGER.info("Entered the update user method in user service");
        Optional<User> userOptional = userRepository.findById(user.getId());
        Boolean response = Boolean.FALSE;
        if (!userOptional.isEmpty()) {
            userRepository.save(user);
            response = Boolean.TRUE;
        }else{
            LOGGER.error("Error in updating the user");
            throw new Exception("Error in updating the user");
        }
        LOGGER.info("Exiting the update user method in user service");
        return response;
    }

    @SchemaMapping
    @Override
    public Boolean delete(UUID userId) throws Exception {
        LOGGER.info("Entered the delete user method in user service");
        Optional<User> userOptional = userRepository.findById(userId);

        Boolean response = Boolean.FALSE;
        if (!userOptional.isEmpty()) {
            userRepository.delete(userOptional.get());
            response = Boolean.TRUE;
        }else{
            LOGGER.error("Error in deleting the user");
            throw new Exception("Error in deleting the user");
        }
        LOGGER.info("Exiting the delete user method in user service");
        return response;
    }

    @SchemaMapping
    @Override
    public User get(UUID userId) throws Exception {
        LOGGER.info("Entered the get user method in user service");
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            LOGGER.error("No user found with the ID {}" , userId);
            throw new Exception("No user found with the ID " + userId);
        }
        LOGGER.info("Exiting the get user method in user service");
        return userOptional.get();
    }

    @SchemaMapping
    @Override
    public List<User> getAll() throws Exception {
        LOGGER.info("Entered the getAll users method in user service");
        List<User> users = userRepository.findAll();
        if (users.size()==0) {
            LOGGER.error("No users found");
            throw new Exception("No users found");
        }
        LOGGER.info("Exiting the getAll users method in user service");
        return users;
    }
}
