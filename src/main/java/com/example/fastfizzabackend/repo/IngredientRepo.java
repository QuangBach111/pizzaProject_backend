package com.example.fastfizzabackend.repo;

import com.example.fastfizzabackend.model.entity.Ingredient;
import com.example.fastfizzabackend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
//    List<Ingredient>
}