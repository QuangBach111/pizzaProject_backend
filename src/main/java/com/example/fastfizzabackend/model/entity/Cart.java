package com.example.fastfizzabackend.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="carts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    private Double totalPrice;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name="order_id")
    @JsonBackReference
    private Order order;

    @Override
    public String toString() {
        return "Cart{" +
            "id=" + id +
            ", quantity=" + quantity +
            ", totalPrice=" + totalPrice +
            '}';
    }
}