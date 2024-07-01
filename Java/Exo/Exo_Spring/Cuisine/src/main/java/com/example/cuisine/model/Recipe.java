package com.example.cuisine.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    private UUID id;
    @NotBlank
    @NotNull
    private String name;

    private List<String> ingredients;

    private List<String> instructions;



    private String categorie;

    private Categorie category;

    public void addIngredient(String ingredient){
        ingredients.add(ingredient);
    }

    public void addInstruction(String instruction){instructions.add(instruction);}

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                ", category=" + category +
                '}';
    }
}
