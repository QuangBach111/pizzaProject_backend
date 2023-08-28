package com.example.fastfizzabackend.controller;

import com.example.fastfizzabackend.model.dto.ItemDTO;
import com.example.fastfizzabackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping("/menu")
    private ResponseEntity<List<ItemDTO>> getMenu() {
        return ResponseEntity.ok(itemService.getAllItemDTO());
    }
}