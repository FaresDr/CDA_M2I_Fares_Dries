package com.example.cuisine.service;



import com.example.cuisine.model.Categorie;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CategoryService {
    private final Map<UUID, Categorie> categorieMap;

    public CategoryService() {
        categorieMap = new HashMap<>();
    }

    public List<Categorie> getAllCategory(){
        return categorieMap.values().stream().toList();
    }

    public Categorie getById(UUID id){ return categorieMap.get(id);}

    public void addCategory(Categorie c){
        categorieMap.put(c.getId(),c);
    }

    public void deleteCateogry(UUID id){
        categorieMap.remove(id);
    }

    public void updateCategory(UUID id, String name,String description){
        Categorie c = getById(id);
        if(name!=""){c.setName(name);}
        if(description!=""){c.setDescription(description);}
    }
    public Categorie getCategoryByName(String name) {
        return categorieMap.values().stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
    }

}
