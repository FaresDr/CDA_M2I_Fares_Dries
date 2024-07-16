package org.example.tp_spring_react.dto.candidateDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatDTOPost {
    private String name;
    private int identificationNumber;
    private String address;
    private String phone;
    private String email;
    private String birthDate;
    private int rating;
    private String observation;
    private String skills;
    private String wantedJob;
    private String jobInterviewDate;
}
