package org.example.tp_spring_react.repository;

import org.example.tp_spring_react.entity.Candidate;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {
}
