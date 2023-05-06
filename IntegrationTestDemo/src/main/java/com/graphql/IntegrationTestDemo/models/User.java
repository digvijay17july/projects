package com.graphql.IntegrationTestDemo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/*
 * @project IntegrationTestDemo
 * @author Digvijay Singh
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    UUID id;
    String userName;
    String address;
    int phoneNumber;
}
