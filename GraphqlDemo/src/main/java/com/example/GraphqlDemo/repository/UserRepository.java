package com.example.GraphqlDemo.repository;

import com.example.GraphqlDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/*
 * @project GraphqlDemo
 * @author Digvijay Singh
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
