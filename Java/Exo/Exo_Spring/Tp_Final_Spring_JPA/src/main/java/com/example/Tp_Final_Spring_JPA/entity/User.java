package com.example.Tp_Final_Spring_JPA.entity;

import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<Answer> answers;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<Subject> subjects;

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", id=" + id +
                '}';
    }
}
