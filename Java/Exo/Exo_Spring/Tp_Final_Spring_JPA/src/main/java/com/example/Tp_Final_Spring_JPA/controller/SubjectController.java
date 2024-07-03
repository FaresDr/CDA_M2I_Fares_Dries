package com.example.Tp_Final_Spring_JPA.controller;


import com.example.Tp_Final_Spring_JPA.entity.Subject;
import com.example.Tp_Final_Spring_JPA.entity.User;
import com.example.Tp_Final_Spring_JPA.services.SubjectService;
import com.example.Tp_Final_Spring_JPA.services.UserService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class SubjectController {
    private final SubjectService subjectService;
    private final HttpSession httpSession;
    private final UserService userService;

    public SubjectController(SubjectService subjectService, HttpSession httpSession,UserService userService) {this.subjectService = subjectService;this.httpSession = httpSession;this.userService=userService;}

    @GetMapping("/subjects")
    public String subjects(Model model) {
        User toto = userService.findByNameAndPassword(((User) httpSession.getAttribute("user")).getUsername(), ((User) httpSession.getAttribute("user")).getPassword());
        model.addAttribute("user", toto);
        model.addAttribute("subjects", subjectService.findAll());
        return "subjects";
    }

    @GetMapping("/subjects/add")
    public String addSubject(Model model) {
        System.out.println(httpSession.getAttribute("logged"));

        System.out.println(httpSession.getAttribute("user"));
        if (httpSession.getAttribute("logged").equals(true) && httpSession.getAttribute("user") != null ) {
            model.addAttribute("subject", new Subject());
            return "subjectForm";
        }else {
            return "redirect:/login";
        }
    }

    @PostMapping("/subjects/add")
    public String addSubject(@ModelAttribute("subject") Subject subject) {
        if (subject.getId()==null) {
            User toto = userService.findByNameAndPassword(((User) httpSession.getAttribute("user")).getUsername(), ((User) httpSession.getAttribute("user")).getPassword());

            subject.setUser(toto);
            LocalDateTime now = LocalDateTime.now();
            subject.setDate(now);

            subjectService.save(subject);
        }else {
            User toto = userService.findByNameAndPassword(((User) httpSession.getAttribute("user")).getUsername(), ((User) httpSession.getAttribute("user")).getPassword());

            subject.setUser(toto);
            LocalDateTime now = LocalDateTime.now();
            subject.setDate(now);
            subjectService.update(subject);
        }
        return "redirect:/subjects";
    }

    @GetMapping("/subjects/delete/{id}")
    public String deleteSubject(@PathVariable("id") Long id) {
        System.out.println(httpSession.getAttribute("user"));
        User toto = userService.findByNameAndPassword(((User) httpSession.getAttribute("user")).getUsername(),((User) httpSession.getAttribute("user")).getPassword());
        System.out.println("jgeizegjirhhI");
        System.out.println(toto);
        for (Subject t: toto.getSubjects()){
            if(t.equals(subjectService.findById(id))){
                subjectService.delete(t);
            }
        }
        return "redirect:/subjects";
    }
    @GetMapping("/subjects/update/{idsub}")
    public String formUpdate(@PathVariable("idsub") Long idsub, Model model){
        User toto = userService.findByNameAndPassword(((User) httpSession.getAttribute("user")).getUsername(),((User) httpSession.getAttribute("user")).getPassword());
        System.out.println("jgeizegjirhhI");
        System.out.println(toto);
        for (Subject t: toto.getSubjects()){
            if(t.equals(subjectService.findById(idsub))){
                Subject subject = subjectService.findById(idsub);
                model.addAttribute("subject", subject);
                return "subjectForm";
            }


        }
        return "redirect:/subjects";
    }
    @GetMapping("/subjects/details/{idsub}")
    public String details(@PathVariable("idsub") Long idsub, Model model){
        model.addAttribute("subject", subjectService.findById(idsub));
        User toto = userService.findByNameAndPassword(((User) httpSession.getAttribute("user")).getUsername(),((User) httpSession.getAttribute("user")).getPassword());
        model.addAttribute("user", toto);
        return "details";
    }
}
