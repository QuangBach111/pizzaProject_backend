package com.example.fastfizzabackend.model.dto;

import com.example.fastfizzabackend.utils.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    @JsonProperty("customer")
    private String username;
    private String phone;
    private String address;
    @JsonProperty("orderPrice")
    private Double totalPrice;
    private OrderStatus status;
    @JsonProperty("cart")
    private List<CartDTO> cartDTOS;
    private Boolean priority;
    private Double priorityPrice;
    private LocalDateTime estimatedDelivery;

}