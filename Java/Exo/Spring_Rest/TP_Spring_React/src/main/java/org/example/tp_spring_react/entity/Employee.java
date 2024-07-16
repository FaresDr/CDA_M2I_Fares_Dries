package org.example.tp_spring_react.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int identificationNumber;
    private String address;
    private String phone;
    private String email;
    private LocalDate birthDate;
    private LocalDate contractStart;
    private LocalDate contractEnd;
    private String occupation;
    private String password;
    private boolean admin;
    private double salary;
    private String observation;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Absence> absenceList;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Vacances> vacancesList;
}
