package org.example.exo_2_film.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    private LocalDate releaseDate;
    private double duration;
    private String genre;
    @ManyToOne
    @JoinColumn(name = "id_real")
    private Realisateur realisateur;
}
