package com.example.fastfizzabackend.model.dto;

import com.example.fastfizzabackend.model.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDTO {
    private Long id;
    private String name;
    private Integer unitPrice;
    private String imageUrl;
    private Boolean soldOut;
    private List<String> ingredients;

}