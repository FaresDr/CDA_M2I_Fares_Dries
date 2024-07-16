package org.example.exo_1_todo.controller;

import org.example.exo_1_todo.dto.TodoPostDto;
import org.example.exo_1_todo.entity.Todo;
import org.example.exo_1_todo.repository.TodoRepository;
import org.example.exo_1_todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo/")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.ok(todoService.findAllTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(todoService.findTodoById(id));
    }

    @GetMapping("/delete/{id}")
    public void deleteTodo(@PathVariable("id") int id) {
        Todo todo = todoService.findTodoById(id);
        todoService.deleteTodo(todo);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
        Todo todo1 = todoService.findTodoById(id);
        todo1.setTitle(todo.getTitle());
        todo1.setDescription(todo.getDescription());
        return ResponseEntity.ok(todoService.updateTodo(todo1));
    }

    @PostMapping("/envoi")
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.createTodo(todo));
    }
}
