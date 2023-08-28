package com.example.fastfizzabackend.model.entity;

import com.example.fastfizzabackend.utils.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Cart> carts;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    private Boolean priority;

    private Double priorityPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PREPARED;

    private Double totalPrice;

    private LocalDateTime createAt = LocalDateTime.now();
    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", user=" + user +
            '}';
    }
}