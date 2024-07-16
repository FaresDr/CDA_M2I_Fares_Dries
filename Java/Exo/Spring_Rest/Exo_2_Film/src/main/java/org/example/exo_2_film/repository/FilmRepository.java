package org.example.exo_2_film.repository;

import org.example.exo_2_film.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FilmRepository extends CrudRepository<Film, Integer> {
}
