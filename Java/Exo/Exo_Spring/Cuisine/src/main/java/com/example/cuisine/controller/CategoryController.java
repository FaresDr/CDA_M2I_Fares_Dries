package com.example.cuisine.controller;

import com.example.cuisine.model.Categorie;
import com.example.cuisine.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller

public class CategoryController {

    private final CategoryService cs;

    public CategoryController(CategoryService cs) {
        this.cs = cs;
    }

    @GetMapping("/")
    public String homePage(){
        return "homePage";
    }

    @GetMapping("/category/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Categorie());
        return "form/categoryForm";
    }
    @PostMapping("category/add")
    public String submitStudent(@Valid @ModelAttribute("category") Categorie categorie, BindingResult result) {
        if(result.hasErrors()){
            return "form/categoryForm";
        }


        System.out.println(categorie);
        if (categorie.getId() == null) {
         Categorie c = Categorie.builder().id(UUID.randomUUID()).name(categorie.getName()).description(categorie.getDescription()).build();
         cs.addCategory(c);
            System.out.println(cs.getAllCategory());
        }
       else {
           cs.updateCategory(categorie.getId(),categorie.getName(),categorie.getDescription());
       }
        return "redirect:/category/list";
    }

    @GetMapping("/category/list")
    public String getAllCategory(Model model){
        List<Categorie> categories = cs.getAllCategory();
        model.addAttribute("categories",categories);
        return "listCategory";
    }

    @GetMapping("/category/detail/{categoryid}")
    public String detailPage(@PathVariable("categoryid")UUID categoryid, Model model){
        Categorie categorie = cs.getById(categoryid);
        model.addAttribute("category", categorie);
        return "categoryDetails";
    }
    @GetMapping("/category/delete/{categoryid}")
    public String delete(@PathVariable("categoryid")UUID categoryid){
        cs.deleteCateogry(categoryid);
        return "redirect:/category/list";
    }

    @GetMapping("/category/update/{categoryid}")
    public String update(@PathVariable("categoryid")UUID categoryid, Model model){
        System.out.println(categoryid);
        Categorie c = cs.getById(categoryid);
        if(c!=null){
            model.addAttribute("category",c);
        }
        return "form/categoryForm";
    }


}
