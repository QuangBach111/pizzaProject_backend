package com.example.fastfizzabackend.repo;

import com.example.fastfizzabackend.model.dto.ItemDTO;
import com.example.fastfizzabackend.model.entity.Item;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
    attributePaths = {
        "ingredients"
    })
    List<Item> findAll();
}