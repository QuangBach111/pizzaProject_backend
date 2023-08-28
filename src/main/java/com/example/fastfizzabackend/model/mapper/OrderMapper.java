package com.example.fastfizzabackend.model.mapper;

import com.example.fastfizzabackend.model.dto.OrderDTO;
import com.example.fastfizzabackend.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class OrderMapper {
    @Autowired
    private CartMapper cartMapper;
    public OrderDTO mapToOrderDTO(Order order) {
        LocalDateTime estimatedDelivery = order.getCreateAt().plus(45, ChronoUnit.MINUTES);

        return OrderDTO.builder()
            .id(order.getId())
            .username(order.getUser().getUsername())
            .phone(order.getUser().getPhone())
            .address(order.getUser().getAddress())
            .status(order.getStatus())
            .totalPrice(order.getTotalPrice())
            .priority(order.getPriority())
            .priorityPrice(order.getPriorityPrice())
            .estimatedDelivery(estimatedDelivery)
            .cartDTOS(cartMapper.mapToCartDTOList(order.getCarts()))
            .build();
    }
}