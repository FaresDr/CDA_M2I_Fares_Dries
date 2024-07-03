package com.example.Tp_Final_Spring_JPA.services;

import com.example.Tp_Final_Spring_JPA.dao.SubjectRepository;
import com.example.Tp_Final_Spring_JPA.entity.Subject;
import com.example.Tp_Final_Spring_JPA.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectService implements ISubjectService {
    private final SubjectRepository subjectRepository;
    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {this.subjectRepository = subjectRepository;}

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject update(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void delete(Subject subject) {
        subjectRepository.delete(subject);
    }
}
