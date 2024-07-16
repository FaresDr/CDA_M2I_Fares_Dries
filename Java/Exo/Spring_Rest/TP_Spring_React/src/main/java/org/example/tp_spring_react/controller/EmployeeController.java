package org.example.tp_spring_react.controller;

import org.example.tp_spring_react.dto.absenceDTO.AbsenceDToPost;
import org.example.tp_spring_react.dto.candidateDTO.CandidatDTOPost;
import org.example.tp_spring_react.dto.employeeDTO.EmployeeDTOGet;
import org.example.tp_spring_react.dto.employeeDTO.EmployeeDTOPost;
import org.example.tp_spring_react.dto.vacancesDTO.VacancesDTOPost;
import org.example.tp_spring_react.entity.Absence;
import org.example.tp_spring_react.entity.Candidate;
import org.example.tp_spring_react.entity.Employee;
import org.example.tp_spring_react.entity.Vacances;
import org.example.tp_spring_react.service.AbsenceService;
import org.example.tp_spring_react.service.EmployeeService;
import org.example.tp_spring_react.service.VacancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/Employee/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AbsenceService absenceService;
    @Autowired
    private VacancesService vacancesService;


    @PostMapping("add")
    public ResponseEntity<Employee> addCandidate(@RequestBody EmployeeDTOPost employeeDTOPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employeeDTOPost));
    }

    @GetMapping("all")
    public ResponseEntity<List<EmployeeDTOGet>> getAllEmployees() {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.getAllEmployees());
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
         employeeService.deleteEmployeeByiD(id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee " + id + " has been deleted");
    }
    @GetMapping("absence/delete/{id}")
    public ResponseEntity<String> deleteAbsence(@PathVariable int id) {
        absenceService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Absence " + id + " has been deleted");
    }
    @GetMapping("vacances/delete/{id}")
    public ResponseEntity<String> deleteVacances(@PathVariable int id) {
        vacancesService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Vacances " + id + " has been deleted");
    }

    @PostMapping("absence/add")
    public ResponseEntity<Absence> addAbsence( @RequestBody AbsenceDToPost absenceDTOpost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(absenceService.addAbsence(absenceDTOpost));
    }

    @PostMapping("vacances/add")
    public ResponseEntity<Vacances> addVacances(@RequestBody VacancesDTOPost vacancesDTOPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vacancesService.addVacances(vacancesDTOPost));
    }
    @PutMapping("update/{id}")
    public ResponseEntity<EmployeeDTOGet> updateEmployee(@PathVariable int id, @RequestBody EmployeeDTOPost employeeDTOPost) {
        return ResponseEntity.ok(employeeService.updateEmployee(id,employeeDTOPost));
    }
}
