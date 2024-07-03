package com.example.Tp_Final_Spring_JPA.controller;

import com.example.Tp_Final_Spring_JPA.entity.User;
import com.example.Tp_Final_Spring_JPA.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession httpSession;



    public UserController(UserService userService, HttpSession httpSession) {this.userService = userService;
        this.httpSession = httpSession;
    }
    @GetMapping("/")
    public String home(){
        httpSession.setAttribute("user", new User());
        httpSession.setAttribute("logged", false);
        return "home";

    }

    @GetMapping("/signin")
    public String signin(Model model) {
        if (httpSession.getAttribute("logged").equals(false)) {
            model.addAttribute("user", new User());
            return "signinForm";
        }else {
            return "redirect:/";
        }
    }

    @PostMapping("/signin")
    public String signinPost(@ModelAttribute("user") User user) {
        if (userService.findByNameAndPassword(user.getUsername(), user.getPassword()) == null) {
            userService.save(user);
        }else {
            return "redirect:/signin";
        }
        return "redirect:/subjects";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (httpSession.getAttribute("logged").equals(false)) {
            model.addAttribute("user", new User());
            return "loginForm";
        }else {
            return "redirect:/";
        }
    }
    @PostMapping("/login")
    public String loginPost(@ModelAttribute("user") User user) {
//        System.out.println(user);
//        System.out.println(userService.findByNameAndPassword(user.getUsername(), user.getPassword()));
        if(userService.findByNameAndPassword(user.getUsername(), user.getPassword())!=null){
            httpSession.setAttribute("logged", true);
            httpSession.setAttribute("user", user);
            return "redirect:/subjects";
        }else {
            return "redirect:/signin";
        }
    }


    @GetMapping("/logout")
    public String logout() {
        httpSession.setAttribute("logged", false);
        httpSession.setAttribute("user", null);
        return "redirect:/login";
    }
}
