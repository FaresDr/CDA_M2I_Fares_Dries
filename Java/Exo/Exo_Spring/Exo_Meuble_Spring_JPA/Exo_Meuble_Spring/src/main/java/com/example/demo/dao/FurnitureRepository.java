package com.example.demo.dao;

import com.example.demo.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
}
