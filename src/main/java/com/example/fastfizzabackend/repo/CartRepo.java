package com.example.fastfizzabackend.repo;

import com.example.fastfizzabackend.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {
}