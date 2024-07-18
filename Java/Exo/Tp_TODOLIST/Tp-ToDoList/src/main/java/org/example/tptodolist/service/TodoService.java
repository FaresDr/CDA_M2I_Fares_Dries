package org.example.tptodolist.service;

import org.example.tptodolist.entity.Todo;
import org.example.tptodolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements ITodoService{

    @Autowired
    private TodoRepository todoRepository;
    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Optional<Todo> getTodoById(int id) {
        return todoRepository.findById(id);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll() ;
    }

    @Override
    public void deleteTodo(int id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }
}
