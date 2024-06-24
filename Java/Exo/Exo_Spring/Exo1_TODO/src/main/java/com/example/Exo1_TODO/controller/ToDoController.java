package com.example.Exo1_TODO.controller;


import com.example.Exo1_TODO.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ToDoController {
    @RequestMapping("/")
    public String homePage(){
        System.out.println("Accueil");
        return "HomePage";
    }

    @RequestMapping("/details")
    public String getOneTodo(Model model){
        Todo todo = Todo.builder().name("Apprendre Spring").description("Pouvoir gérer des projets via Spring et Maven").isDone(false).build();
        model.addAttribute("name", todo.getName());
        model.addAttribute("description", todo.getDescription());
        model.addAttribute("status",todo.isDone());





        return "details";
    }
    @RequestMapping("/all")
    @ResponseBody
    public List<Todo> getAllTodo(){
        Todo todo = Todo.builder().name("Apprendre Spring").description("Pouvoir gérer des projets via Spring et Maven").isDone(false).build();
        Todo todo2 = Todo.builder().name("Apprendre Hibernate").description("Pouvoir gérer des projets via Hibernate et Maven").isDone(true).build();
        Todo todo3 = Todo.builder().name("Faires des cookies").description("Préparer des cookies pour un après midi").isDone(true).build();

        List<Todo> todoList = List.of(todo,todo2,todo3);
        return todoList;
    }
}
