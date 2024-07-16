package org.example.exo_2_film.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmToPostDTO {
    private int idreal;
    private String title;
    private String description;
    private String date;
    private String genre;
    private double duration;
}
