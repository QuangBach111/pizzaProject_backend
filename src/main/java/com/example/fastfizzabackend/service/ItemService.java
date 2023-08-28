package com.example.fastfizzabackend.service;

import com.example.fastfizzabackend.model.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    List<ItemDTO> getAllItemDTO();
}