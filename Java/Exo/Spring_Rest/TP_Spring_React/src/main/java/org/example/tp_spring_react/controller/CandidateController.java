package org.example.tp_spring_react.controller;

import org.example.tp_spring_react.dto.candidateDTO.CandidatDTOPost;
import org.example.tp_spring_react.dto.employeeDTO.EmployeeDTOGet;
import org.example.tp_spring_react.dto.employeeDTO.EmployeeDTOPost;
import org.example.tp_spring_react.entity.Candidate;
import org.example.tp_spring_react.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/candidate/")
public class CandidateController {

    @Autowired
    private CandidatService candidatService;

    @PostMapping("add")
    public ResponseEntity<Candidate> addCandidate(@RequestBody CandidatDTOPost candidate) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidatService.addCandidate(candidate));
    }

    @GetMapping("all")
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        return ResponseEntity.status(HttpStatus.OK).body(candidatService.getAllCandidates());
    }

    @GetMapping("{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(candidatService.getCandidate(id));
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<String>  deleteCandidate(@PathVariable int id) {
        candidatService.deleteCandidate(id);
        return ResponseEntity.status(HttpStatus.OK).body("Candidat " + id + " has been deleted");
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Candidate> updateCandidat(@PathVariable int id, @RequestBody CandidatDTOPost c) {
        return ResponseEntity.ok(candidatService.updateCandidate(id,c));
    }
}
