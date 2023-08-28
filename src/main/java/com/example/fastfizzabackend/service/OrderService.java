package com.example.fastfizzabackend.service;

import com.example.fastfizzabackend.model.dto.OrderDTO;
import com.example.fastfizzabackend.model.entity.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface OrderService {
    Long createOrder(OrderDTO orderDTO);

    OrderDTO getOrderById(Long orderId);
}