package org.example.tptodolist.repository;

import org.example.tptodolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends JpaRepository<Todo,Integer> {
}
