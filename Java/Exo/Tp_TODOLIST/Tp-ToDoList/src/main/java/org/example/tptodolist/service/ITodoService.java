package org.example.tptodolist.service;

import org.example.tptodolist.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface ITodoService {

    public Todo saveTodo(Todo todo);
    public Optional<Todo> getTodoById(int id);
    public List<Todo> getAllTodos();
    public void deleteTodo(int id);
    public Todo updateTodo(Todo todo);
}
