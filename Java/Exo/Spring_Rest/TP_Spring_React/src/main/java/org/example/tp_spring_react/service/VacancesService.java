package org.example.tp_spring_react.service;

import org.example.tp_spring_react.dto.vacancesDTO.VacancesDTOPost;
import org.example.tp_spring_react.entity.Vacances;
import org.example.tp_spring_react.repository.AbsenceRepository;
import org.example.tp_spring_react.repository.VacancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VacancesService {
    @Autowired
    private VacancesRepository vacancesRepository;
    @Autowired
    private EmployeeService employeeService;

    public Vacances addVacances(VacancesDTOPost vacancesDTOPost) {
        Vacances vacances = Vacances.builder()
                .employee(employeeService.getNormalEmployeeById(vacancesDTOPost.getIdemployee()))
                .beginning(LocalDate.parse(vacancesDTOPost.getBeggining()))
                .end(LocalDate.parse(vacancesDTOPost.getEnd()))
                .build();
        return vacancesRepository.save(vacances);
    }

    public void delete(int id){
        vacancesRepository.deleteById(id);
    }
}
