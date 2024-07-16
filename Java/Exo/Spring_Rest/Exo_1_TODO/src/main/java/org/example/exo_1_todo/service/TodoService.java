package org.example.exo_1_todo.service;

import org.example.exo_1_todo.entity.Todo;
import org.example.exo_1_todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService  {
    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodo(Todo todo) {
        todoRepository.delete(todo);
    }

    public List<Todo> findAllTodos() {
        return (List<Todo>) todoRepository.findAll();
    }

    public Todo findTodoById(int id) {
        return todoRepository.findById(id).orElse(null);
    }
}
