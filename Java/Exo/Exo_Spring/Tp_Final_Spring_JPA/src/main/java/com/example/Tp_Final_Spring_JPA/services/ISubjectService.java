package com.example.Tp_Final_Spring_JPA.services;

import com.example.Tp_Final_Spring_JPA.entity.Subject;
import com.example.Tp_Final_Spring_JPA.entity.User;

import java.util.List;

public interface ISubjectService {
    List<Subject> findAll();
    Subject findById(Long id);

    Subject save(Subject subject);
    Subject update(Subject subject);
    void delete(Subject subject);
}
