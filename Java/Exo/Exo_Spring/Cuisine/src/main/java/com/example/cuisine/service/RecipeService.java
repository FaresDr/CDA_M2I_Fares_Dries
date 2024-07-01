package com.example.cuisine.service;

import com.example.cuisine.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service

public class RecipeService {
    private final Map<UUID, Recipe> recipeMap;
    public RecipeService() {
        recipeMap = new HashMap<>();
    }
    public List<Recipe> getAllRecipes(){
        return recipeMap.values().stream().toList();
    }

    public Recipe getById(UUID id){
        return recipeMap.get(id);
    }
    public void add(Recipe r){
        recipeMap.put(r.getId(),r);
    }
    public void delete(UUID id){recipeMap.remove(id);}
}
