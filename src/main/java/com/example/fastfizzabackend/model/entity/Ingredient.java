package com.example.fastfizzabackend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ingredients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Override
    public String toString() {
        return "Ingredient{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}