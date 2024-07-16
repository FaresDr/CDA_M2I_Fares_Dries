package org.example.exo_2_film.service;

import org.example.exo_2_film.dto.RealPostDTO;
import org.example.exo_2_film.entity.Film;
import org.example.exo_2_film.entity.Realisateur;
import org.example.exo_2_film.repository.FilmRepository;
import org.example.exo_2_film.repository.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class RealisateurService {
    @Autowired
    private RealisateurRepository realisateurRepository;

    @Autowired
    private FilmRepository filmRepository;

    public List<Realisateur> getAllRealisateurs(){
        return (List<Realisateur>) realisateurRepository.findAll();
    }
    public Realisateur getRealisateurById(int id){
        return realisateurRepository.findById(id).orElse(null);
    }

    public Realisateur createRealisateur(RealPostDTO realisateur){

        Realisateur realisateur1 = Realisateur.builder()
                .nom(realisateur.getName())
                .prenom(realisateur.getLastname())
                .nationalite(realisateur.getNationalite())
                .dateNaissance(LocalDate.parse(realisateur.getBirthdate()))
                .build();
        return realisateurRepository.save(realisateur1);
    }
    public void deleteRealisateurById(int id){
        realisateurRepository.deleteById(id);
    }

    public List<Film> getAllFilmsByRealisateur(Realisateur realisateur){
        return (List<Film>) filmRepository.findById(realisateur.getId()).orElse(null);
    }
}
