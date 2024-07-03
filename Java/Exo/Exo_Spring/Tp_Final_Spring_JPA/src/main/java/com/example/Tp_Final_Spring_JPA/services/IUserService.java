package com.example.Tp_Final_Spring_JPA.services;

import com.example.Tp_Final_Spring_JPA.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Long id);
    User findByNameAndPassword(String name, String password);
    User save(User user);
    User update(User user);
    void delete(User user);
}
