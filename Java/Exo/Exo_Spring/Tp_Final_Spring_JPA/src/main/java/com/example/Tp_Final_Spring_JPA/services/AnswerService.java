package com.example.Tp_Final_Spring_JPA.services;

import com.example.Tp_Final_Spring_JPA.dao.AnswerRepository;
import com.example.Tp_Final_Spring_JPA.entity.Answer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService implements IAnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Answer findById(int id) {
        return answerRepository.findById(id).orElse(null);
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer update(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public void delete(Answer answer) {
        answerRepository.delete(answer);
    }
}
