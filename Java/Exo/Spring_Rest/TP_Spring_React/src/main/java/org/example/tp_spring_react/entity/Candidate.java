package org.example.tp_spring_react.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int identificationNumber;
    private String address;
    private String phone;
    private String email;
    private LocalDate birthDate;
    private int rating;
    private String observation;
    private String skills;
    private String wantedJob;
    private LocalDate jobInterviewDate;
}
