package org.example.tptodolist.controller;

import org.example.tptodolist.entity.Todo;
import org.example.tptodolist.entity.User;
import org.example.tptodolist.service.ITodoService;
import org.example.tptodolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("todos")
public class TodoController {

    @Autowired
    private ITodoService todoService;


    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Todo> getProductById(@PathVariable int id) {
        Optional<Todo> product = todoService.getTodoById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/admin/post")
    public ResponseEntity<Todo> createProduct(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.saveTodo(todo));
    }
    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        todoService.deleteTodo(id);
       return ResponseEntity.ok().build() ;
    }

    @PutMapping("/admin/update")
    public ResponseEntity<Todo> updateProduct(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.updateTodo(todo));
    }

}
