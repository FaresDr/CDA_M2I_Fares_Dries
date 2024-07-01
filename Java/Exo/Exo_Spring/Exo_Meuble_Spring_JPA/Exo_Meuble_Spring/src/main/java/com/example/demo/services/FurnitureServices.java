package com.example.demo.services;

import com.example.demo.dao.FurnitureRepository;
import com.example.demo.entity.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FurnitureServices implements IFurnitureService{

    private FurnitureRepository furnitureRepository;

    @Autowired
    public FurnitureServices(FurnitureRepository furnitureRepository) {this.furnitureRepository = furnitureRepository;}


    public List<Furniture> findAll() {
        return furnitureRepository.findAll();
    }

    @Override
    public Furniture findById(Long id) {
        return furnitureRepository.findById(id).orElse(null);
    }

    @Override
    public Furniture save(Furniture furniture) {
        furnitureRepository.save(furniture);
        return furniture;
    }

    @Override
    public Furniture update(Furniture furniture) {
        furnitureRepository.save(furniture);
        return furniture;
    }

    @Override
    public void delete(Furniture furniture) {
        furnitureRepository.delete(furniture);
    }
}
