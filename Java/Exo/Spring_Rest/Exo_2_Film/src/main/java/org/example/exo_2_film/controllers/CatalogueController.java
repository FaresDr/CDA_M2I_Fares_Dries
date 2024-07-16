package org.example.exo_2_film.controllers;


import org.example.exo_2_film.dto.FilmToPostDTO;
import org.example.exo_2_film.dto.RealPostDTO;
import org.example.exo_2_film.entity.Film;
import org.example.exo_2_film.entity.Realisateur;
import org.example.exo_2_film.service.FilmService;
import org.example.exo_2_film.service.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/catalogue/")
public class CatalogueController {

    @Autowired
    FilmService filmService;
    @Autowired
    RealisateurService realisateurService;

    @GetMapping("films")
    public ResponseEntity<List<Film>> getAll (){
        return ResponseEntity.ok(filmService.getAllFilms());
    }

    @PostMapping("films/add")
    public ResponseEntity<Film> addFilm (@RequestBody FilmToPostDTO film){
        return ResponseEntity.status(HttpStatus.CREATED).body(filmService.addFilm(film));
    }

//    @GetMapping("films/{id}")

    @PostMapping("realisateur/add")
    public ResponseEntity<Realisateur> addRealisateur (@RequestBody RealPostDTO realisateur){
        return ResponseEntity.status(HttpStatus.CREATED).body(realisateurService.createRealisateur(realisateur));
    }


}
