package com.example.fastfizzabackend.repo;

import com.example.fastfizzabackend.model.entity.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order, Long> {
    @EntityGraph(type=EntityGraph.EntityGraphType.FETCH,
        attributePaths={
           "user"
        }
    )
    Optional<Order> findOrderById(Long id);
}