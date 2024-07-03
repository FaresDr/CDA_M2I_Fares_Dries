package com.example.Tp_Final_Spring_JPA.dao;

import com.example.Tp_Final_Spring_JPA.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}
