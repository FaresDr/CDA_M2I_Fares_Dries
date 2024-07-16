package org.example.tp_spring_react.repository;

import org.example.tp_spring_react.entity.Absence;
import org.springframework.data.repository.CrudRepository;

public interface AbsenceRepository extends CrudRepository<Absence, Integer> {
}
