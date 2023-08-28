package com.example.fastfizzabackend.model.mapper;

import com.example.fastfizzabackend.model.dto.ItemDTO;
import com.example.fastfizzabackend.model.entity.Ingredient;
import com.example.fastfizzabackend.model.entity.Item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {
    public ItemDTO mapToItemDTO(Item item) {
        return ItemDTO.builder()
            .id((item.getId()))
            .name(item.getName())
            .unitPrice(item.getUnitPrice())
            .imageUrl(item.getImageUrl())
            .soldOut(item.getSoldOut())
            .ingredients(
                item.getIngredients()
                    .stream()
                    .map(ingredient -> ingredient.getName())
                    .collect(Collectors.toList())
            )
            .build();
    }
    public List<ItemDTO> mapToItemDTOList(List<Item> items){
        return items.stream()
            .map(
                item -> mapToItemDTO(item)).collect(Collectors.toList()
            );
    }
}