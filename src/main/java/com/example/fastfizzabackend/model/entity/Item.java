package com.example.fastfizzabackend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "sold_out")
    private Boolean soldOut;

    @OneToMany(mappedBy = "item")
    private List<Ingredient> ingredients;

//    @OneToMany(mappedBy = "item")
//    private List<CartItem> cartItems;

    @Override
    public String toString() {
        return "Item{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", unitPrice=" + unitPrice +
            ", imageUrl='" + imageUrl + '\'' +
            ", soldOut=" + soldOut +
            '}';
    }
}