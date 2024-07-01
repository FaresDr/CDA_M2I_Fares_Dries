package com.example.demo.services;

import com.example.demo.entity.Furniture;

import java.util.List;

public interface IFurnitureService {
    List<Furniture> findAll();
    Furniture findById(Long id);
    Furniture save(Furniture furniture);
    Furniture update(Furniture furniture);
    void delete(Furniture furniture);
}
