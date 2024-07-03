package com.example.Tp_Final_Spring_JPA.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private List<Answer> answers;
}
