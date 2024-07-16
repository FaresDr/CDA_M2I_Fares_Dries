package org.example.exo_2_film.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealPostDTO {
    private String name;
    private String lastname;
    private String birthdate;
    private String nationalite;
}
