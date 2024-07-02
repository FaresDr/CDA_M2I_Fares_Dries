package com.example.demo.controller;

import com.example.demo.dao.FurnitureRepository;
import com.example.demo.entity.Furniture;
import com.example.demo.services.FurnitureServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller

public class FurnitureController {

    private final FurnitureServices furnitureServices;

    public FurnitureController(FurnitureServices furnitureServices) {this.furnitureServices = furnitureServices;}

    @GetMapping("/furniture")
    public String home(Model model){
        model.addAttribute("meubles", furnitureServices.findAll());
        return "home";
    }

    @GetMapping("/furniture/addForm")
    public String addForm(Model model){
        model.addAttribute("furniture", new Furniture());
        return "furnitureForm";
    }

    @PostMapping("/furniture/addFurniture")
    public String addPerson(@ModelAttribute("person") Furniture furniture){
        System.out.println(Long.valueOf(furniture.getId()));
        if (Long.valueOf(furniture.getId()) == null)  {
            furnitureServices.save(furniture);
        }else {
            furnitureServices.update(furniture);
        }
        return "redirect:/";
    }

    @GetMapping("/furniture/delete/{idmeuble}")
    public String delete(@PathVariable("idmeuble") Long idmeuble){
        furnitureServices.delete(furnitureServices.findById(idmeuble));
        return "redirect:/";
    }
    @GetMapping("/furniture/update/{idmeuble}")
    public String formUpdate(@PathVariable("idmeuble") Long idmeuble, Model model){
        Furniture furniture = furnitureServices.findById(idmeuble);
        model.addAttribute("furniture", furniture);
        return "furnitureForm";
    }
}
