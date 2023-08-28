package com.example.fastfizzabackend.model.mapper;

import com.example.fastfizzabackend.model.dto.CartDTO;
import com.example.fastfizzabackend.model.entity.Cart;
import com.example.fastfizzabackend.model.entity.Item;
import com.example.fastfizzabackend.repo.CartRepo;
import com.example.fastfizzabackend.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CartMapper {
    @Autowired
    private ItemRepo itemRepo;

    public Cart mapToCart(CartDTO cartDTO) {
        List<Item> items = itemRepo.findAll();

        return Cart.builder()
            .quantity(cartDTO.getQuantity())
            .totalPrice(cartDTO.getTotalPrice())
            .item(
                items.stream()
                    .filter(item -> Objects.equals(item.getId(), cartDTO.getPizzaId()))
                    .findFirst()
                    .orElseThrow(() -> new EntityNotFoundException("Item is not found! Id: " + cartDTO.getPizzaId()))
            )
            .build();
    }

    public CartDTO mapToCartDTO(Cart cart) {
        return CartDTO.builder()
            .pizzaId(cart.getId())
            .name(cart.getItem().getName())
            .quantity(cart.getQuantity())
            .totalPrice(cart.getTotalPrice())
            .unitPrice(cart.getItem().getUnitPrice())
            .build();
    }

    public List<Cart> mapToCartList(List<CartDTO> cartDTOs) {
        return cartDTOs.stream().map(cartDTO -> mapToCart(cartDTO)).collect(Collectors.toList());
    }

    public List<CartDTO> mapToCartDTOList(List<Cart> carts) {
        return carts.stream()
            .map(cart -> mapToCartDTO(cart))
            .collect(Collectors.toList());
    }
}