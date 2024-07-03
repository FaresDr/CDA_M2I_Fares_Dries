package com.example.Tp_Final_Spring_JPA.services;

import com.example.Tp_Final_Spring_JPA.entity.Answer;
import com.example.Tp_Final_Spring_JPA.entity.User;

import java.util.List;

public interface IAnswerService {
    List<Answer> findAll();
    Answer findById(int id);
    Answer save(Answer answer);
    Answer update(Answer answer);
    void delete(Answer answer);
}
