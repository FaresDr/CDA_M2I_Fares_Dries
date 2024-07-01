package com.example.cuisine.controller;

import com.example.cuisine.model.Categorie;
import com.example.cuisine.model.Recipe;
import com.example.cuisine.service.CategoryService;
import com.example.cuisine.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class RecipeController {

    private final RecipeService rs;
    private final CategoryService cs;

    public RecipeController(RecipeService rs, CategoryService cs) {
        this.rs = rs;
        this.cs = cs;
    }




    @GetMapping("/recipe/add")
    public String addCategory(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("categories",cs.getAllCategory());
        return "form/recipeForm";
    }
    @PostMapping("/recipe/add")
    public String submitRecipe(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult result) {
//        if(result.hasErrors()){
//            return "redirect:/recipe/add";
//        }

        System.out.println(recipe);
        System.out.println(recipe.getIngredients());
        if (recipe.getId() == null) {
            System.out.println(recipe);
            Recipe r = Recipe.builder().id(UUID.randomUUID()).name(recipe.getName()).category(cs.getById(UUID.fromString(recipe.getCategorie()))).ingredients(recipe.getIngredients()).instructions(recipe.getInstructions()).build();
            System.out.println(r);
            rs.add(r);
        }
//        else {
//            cs.updateCategory(categorie.getId(),categorie.getName(),categorie.getDescription());
//        }
        return "redirect:/recipe/list";
    }
    @GetMapping("/recipe/list")
    public String getAllCategory(Model model){
        List<Recipe> recipes = rs.getAllRecipes();
        model.addAttribute("recipes",recipes);
        return "listRecipe";
    }

    @GetMapping("/recipe/detail/{recipeid}")
    public String detailPage(@PathVariable("recipeid")UUID recipeid, Model model){
        Recipe recipe = rs.getById(recipeid);
        model.addAttribute("recipe", recipe);
        return "recipeDetails";
    }
    @GetMapping("/recipe/delete/{recipeid}")
    public String delete(@PathVariable("recipeid")UUID recipeid){
        rs.delete(recipeid);
        return "redirect:/recipe/list";
    }



}
