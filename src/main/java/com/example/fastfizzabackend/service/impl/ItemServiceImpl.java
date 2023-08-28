package com.example.fastfizzabackend.service.impl;

import com.example.fastfizzabackend.model.dto.ItemDTO;
import com.example.fastfizzabackend.model.mapper.ItemMapper;
import com.example.fastfizzabackend.repo.ItemRepo;
import com.example.fastfizzabackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<ItemDTO> getAllItemDTO() {
        return itemMapper.mapToItemDTOList(itemRepo.findAll());
    }
}