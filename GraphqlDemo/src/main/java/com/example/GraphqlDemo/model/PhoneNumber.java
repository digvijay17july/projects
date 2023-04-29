package com.example.GraphqlDemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/*
 * @project GraphqlDemo
 * @author Digvijay Singh
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "phone_number")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column
    String primaryPhoneNumber;
    @ElementCollection
    @Column
    List<String> SecondaryPhoneNumbers;
}
