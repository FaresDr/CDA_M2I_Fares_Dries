package com.example.Tp_Final_Spring_JPA.controller;

import com.example.Tp_Final_Spring_JPA.dao.AnswerRepository;
import com.example.Tp_Final_Spring_JPA.dao.SubjectRepository;
import com.example.Tp_Final_Spring_JPA.dao.UserRepository;
import com.example.Tp_Final_Spring_JPA.entity.Answer;
import com.example.Tp_Final_Spring_JPA.entity.Subject;
import com.example.Tp_Final_Spring_JPA.entity.User;
import com.example.Tp_Final_Spring_JPA.services.AnswerService;
import com.example.Tp_Final_Spring_JPA.services.SubjectService;
import com.example.Tp_Final_Spring_JPA.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class AnswerController {

   private final AnswerService answerService;
   private final SubjectService subjectService;
   private final UserService userService;
   private final HttpSession httpSession;

    public AnswerController(AnswerService answerService, SubjectService subjectService, UserService userService, HttpSession session) {
        this.answerService = answerService;
        this.subjectService = subjectService;
        this.userService = userService;
        this.httpSession = session;
    }

    @GetMapping("/subjects/answer/{idtopic}")
    public String showAnswer(@PathVariable Long idtopic, Model model) {
        if(httpSession.getAttribute("logged").equals(true)) {
            model.addAttribute("answer", new Answer());
            model.addAttribute("idtopic", idtopic);
            model.addAttribute("user",httpSession.getAttribute("user"));

            return "answerForm";
        }else {
            return "redirect:/login";
        }
    }
    @PostMapping("/subjects/answer/{idtopic}")
    public String saveAnswer(@PathVariable Long idtopic, Answer answer) {
        System.out.println(idtopic);
        User toto = userService.findByNameAndPassword(((User) httpSession.getAttribute("user")).getUsername(),((User) httpSession.getAttribute("user")).getPassword());
        answer.setSubject(subjectService.findById(idtopic));
        answer.setUser(toto);
        answer.setDate(LocalDateTime.now());
        System.out.println(answer);
        System.out.println(answer.getSubject());
        if(answer.getId() == null) {
            answerService.save(answer);
        }else {
            answerService.update(answer);
        }

        return "redirect:/subjects";
    }
    @GetMapping("/subjects/details/delete/{id}")
    public String deleteSubject(@PathVariable("id") int id) {
        System.out.println(httpSession.getAttribute("user"));
        User toto = userService.findByNameAndPassword(((User) httpSession.getAttribute("user")).getUsername(),((User) httpSession.getAttribute("user")).getPassword());
        System.out.println("jgeizegjirhhI");
        System.out.println(toto);
        for (Answer t: toto.getAnswers()){
            if(t.equals(answerService.findById(id))){
                answerService.delete(t);
            }
        }
        return "redirect:/subjects";
    }
    @GetMapping("/subjects/details/update/{id}")
    public String formUpdate(@PathVariable("id") int id, Model model){
        User toto = userService.findByNameAndPassword(((User) httpSession.getAttribute("user")).getUsername(),((User) httpSession.getAttribute("user")).getPassword());
        System.out.println("jgeizegjirhhI");
        System.out.println(toto);
        Answer answer2 = answerService.findById(id);
        for (Answer t: toto.getAnswers()){
            if(t.equals(answerService.findById(id))){
                Answer answer = answerService.findById(id);
                model.addAttribute("answer", answer);
                answer.setSubject(subjectService.findById(answer2.getSubject().getId()));
                model.addAttribute("idtopic", answer2.getSubject().getId());
                return "answerForm";
            }


        }
        return "redirect:/subjects";
    }
}
