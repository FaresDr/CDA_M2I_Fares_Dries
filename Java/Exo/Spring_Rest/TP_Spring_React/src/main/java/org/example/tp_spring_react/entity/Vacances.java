package org.example.tp_spring_react.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
public class Vacances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate beginning;
    private LocalDate end;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_employee")
    @JsonIgnore
    private Employee employee;
}
