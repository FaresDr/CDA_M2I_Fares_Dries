package org.example.exo_2_film.repository;

import org.example.exo_2_film.entity.Realisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RealisateurRepository extends CrudRepository<Realisateur, Integer> {
}
