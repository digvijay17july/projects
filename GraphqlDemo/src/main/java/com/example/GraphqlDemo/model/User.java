package com.example.GraphqlDemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/*
 * @project GraphqlDemo
 * @author Digvijay Singh
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String username;
    @OneToOne(cascade = {CascadeType.ALL})
    Address Address;
    @OneToOne(cascade = {CascadeType.ALL})
    PhoneNumber phoneNumber;

}
