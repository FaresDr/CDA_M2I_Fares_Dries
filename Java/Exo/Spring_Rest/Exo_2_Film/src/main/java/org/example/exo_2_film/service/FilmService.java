package org.example.exo_2_film.service;

import org.example.exo_2_film.dto.FilmToPostDTO;
import org.example.exo_2_film.entity.Film;
import org.example.exo_2_film.repository.FilmRepository;
import org.example.exo_2_film.repository.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private RealisateurRepository realisateurRepository;

    public List<Film> getAllFilms() {
        return (List<Film>) filmRepository.findAll();
    }
    public Film getFilmById(int id) {
        return filmRepository.findById(id).orElse(null);
    }

    public Film addFilm(FilmToPostDTO filmdto) {

        Film film = Film.builder()
                .title(filmdto.getTitle())
                .realisateur(realisateurRepository.findById(filmdto.getIdreal()).orElse(null))
                .genre(filmdto.getGenre())
                .duration(filmdto.getDuration())
                .releaseDate(LocalDate.parse(filmdto.getDate()))
                .description(filmdto.getDescription())
                .build();
        return filmRepository.save(film);


    }
    public void deleteFilm(int id) {
        filmRepository.deleteById(id);
    }
}
