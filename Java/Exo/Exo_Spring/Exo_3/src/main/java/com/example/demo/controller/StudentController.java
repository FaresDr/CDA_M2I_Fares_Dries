package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.services.StudentServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller

public class StudentController {

    private final StudentServices studentServices;

    private StudentController(StudentServices studentServices){ this.studentServices = studentServices;}

    @GetMapping("/")
    public String homePage(){
        return "homePage";
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "form/form";
    }

    @PostMapping("/add")
    public String submitStudent(@ModelAttribute("student") Student student) {
        System.out.println(student.getName());
        System.out.println(student.getLastname());
        System.out.println(student.getEmail());
        Student s = Student.builder().name(student.getName()).lastname(student.getLastname()).email(student.getEmail()).id(UUID.randomUUID()).build();
        System.out.println(s.toString());
        studentServices.add(s);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String allStudent(Model model){
        List<Student> students = studentServices.getAllStudents();
        System.out.println(students);
        model.addAttribute("students",students);
        return "list";
    }
    @GetMapping("/detail/{studentid}")
    public String detailPage(@PathVariable("studentid")UUID studentid, Model model){
        Student student = studentServices.getById(studentid);
        model.addAttribute("student", student);
        return "detail";
    }
}
