package com.example.cuisine.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {

    private UUID id;
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String description;

    @Override
    public String toString() {
        return "Id = " + id + " Nom " + name + " Description = " + description;
    }
}
