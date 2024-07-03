package com.example.Tp_Final_Spring_JPA.dao;

import com.example.Tp_Final_Spring_JPA.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
