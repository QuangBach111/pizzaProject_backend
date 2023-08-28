package com.example.fastfizzabackend.controller;

import com.example.fastfizzabackend.model.dto.OrderDTO;
import com.example.fastfizzabackend.model.entity.Order;
import com.example.fastfizzabackend.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {
  final private OrderService orderService;

  final
  @GetMapping("/{id}")
  private ResponseEntity<OrderDTO> getOrder(@PathVariable("id") Long orderId) {

    return ResponseEntity.ok(orderService.getOrderById(orderId));
  }

  @PostMapping
  private ResponseEntity<Long> createOrder(@RequestBody OrderDTO orderDTO) {
    return ResponseEntity.ok(orderService.createOrder(orderDTO));
  }
}