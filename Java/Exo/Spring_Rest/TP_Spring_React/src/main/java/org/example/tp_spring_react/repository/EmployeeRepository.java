package org.example.tp_spring_react.repository;

import org.example.tp_spring_react.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
