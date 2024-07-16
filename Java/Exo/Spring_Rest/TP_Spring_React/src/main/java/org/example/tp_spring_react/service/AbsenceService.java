package org.example.tp_spring_react.service;

import org.example.tp_spring_react.dto.absenceDTO.AbsenceDToPost;
import org.example.tp_spring_react.entity.Absence;
import org.example.tp_spring_react.repository.AbsenceRepository;
import org.example.tp_spring_react.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service

public class AbsenceService {
    @Autowired
    private AbsenceRepository absenceRepository;
    @Autowired
    private EmployeeService employeeService;

    public Absence addAbsence(AbsenceDToPost absenceDToPost) {

        Absence absence = Absence.builder()
                .employee(employeeService.getNormalEmployeeById(absenceDToPost.getIdEmployee()))
                .dateOfAbsence(LocalDate.parse(absenceDToPost.getDate()))
                .build();
      return   absenceRepository.save(absence);




    }

    public void delete(int id) {
        absenceRepository.deleteById(id);
    }
}
