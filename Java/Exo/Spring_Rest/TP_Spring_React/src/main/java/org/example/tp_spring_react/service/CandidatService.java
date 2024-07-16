package org.example.tp_spring_react.service;

import org.example.tp_spring_react.dto.candidateDTO.CandidatDTOPost;
import org.example.tp_spring_react.entity.Candidate;
import org.example.tp_spring_react.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CandidatService {

    @Autowired
    private CandidateRepository candidateRepository;


    public Candidate addCandidate(CandidatDTOPost candidate) {
        Candidate c = Candidate.builder()
                .name(candidate.getName())
                .identificationNumber(candidate.getIdentificationNumber())
                .address(candidate.getAddress())
                .phone(candidate.getPhone())
                .email(candidate.getEmail())
                .birthDate(LocalDate.parse(candidate.getBirthDate()))
                .rating(candidate.getRating())
                .observation(candidate.getObservation())
                .skills(candidate.getSkills())
                .wantedJob(candidate.getWantedJob())
                .jobInterviewDate(LocalDate.parse(candidate.getJobInterviewDate()))
                .build();
       return candidateRepository.save(c);
    }

    public Candidate getCandidate(int id) {
        return candidateRepository.findById(id).orElse(null);
    }

    public List<Candidate> getAllCandidates() {
        return (List<Candidate>) candidateRepository.findAll();
    }
    public void deleteCandidate(int id) {
        candidateRepository.deleteById(id);
    }

    public Candidate updateCandidate(int id ,CandidatDTOPost candidate) {
        Candidate c = getCandidate(id);
        c.setName(candidate.getName());
        c.setIdentificationNumber(candidate.getIdentificationNumber());
        c.setAddress(candidate.getAddress());
        c.setPhone(candidate.getPhone());
        c.setEmail(candidate.getEmail());
        c.setBirthDate(LocalDate.parse(candidate.getBirthDate()));
        c.setRating(candidate.getRating());
        c.setObservation(candidate.getObservation());
        c.setSkills(candidate.getSkills());
        c.setWantedJob(candidate.getWantedJob());
        c.setJobInterviewDate(LocalDate.parse(candidate.getJobInterviewDate()));
        return candidateRepository.save(c);
    }

}
