package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.services.StudentServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(student);
        System.out.println(student.getName());
        System.out.println(student.getLastname());
        System.out.println(student.getEmail());
        System.out.println(student.getId());
        if (student.getId() == null) {
            Student s = Student.builder().name(student.getName()).lastname(student.getLastname()).email(student.getEmail()).id(UUID.randomUUID()).build();
            System.out.println(s.toString());
            studentServices.add(s);
        }else {
            studentServices.updateStudent(student.getName(),student.getLastname(),student.getEmail(),student.getId());
        }
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

    @GetMapping("/search")
    public String getByName(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "lastname",required = false) String lastname,  Model model){
        System.out.println(name);
        System.out.println(lastname);
        List<Student> students = studentServices.getByNameAndLastName(name,lastname);
        System.out.println(students);
        model.addAttribute("students", students);

        return "list";
    }
    @GetMapping("/delete/{studentid}")
    public String delete(@PathVariable("studentid")UUID studentid){
        studentServices.deleteStudent(studentid);
        return "redirect:/list";
    }
    @GetMapping("/update/{studentid}")
    public String update(@PathVariable("studentid")UUID studentid, Model model){
        System.out.println(studentid);
       Student s = studentServices.getById(studentid);
       if(s!=null){
           model.addAttribute("student",s);
       }
        return "form/form";
    }
}
