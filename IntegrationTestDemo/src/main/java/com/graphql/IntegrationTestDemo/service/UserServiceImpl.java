package com.graphql.IntegrationTestDemo.service;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.graphql.IntegrationTestDemo.models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/*
 * @project IntegrationTestDemo
 * @author Digvijay Singh
 */
@Service
public class UserServiceImpl implements  UserService{

    @Override
    public List<User> getAllUsers() {
        List<User> users=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user=new User();
            user.setUserName(RandomStringUtils.randomAlphabetic(10));
            user.setAddress(RandomStringUtils.randomAlphabetic(20));
            user.setId(UUID.randomUUID());
            user.setPhoneNumber(RandomUtils.nextInt(1,9));
            users.add(user);
        }
        return users;
    }
}
