package com.example.Tp_Final_Spring_JPA.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Answers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Override
    public String toString() {
        return  user.getUsername() +  message ;
    }
}
