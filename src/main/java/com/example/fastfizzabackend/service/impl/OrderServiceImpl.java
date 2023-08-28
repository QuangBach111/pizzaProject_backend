package com.example.fastfizzabackend.service.impl;

import com.example.fastfizzabackend.model.dto.OrderDTO;
import com.example.fastfizzabackend.model.entity.Cart;
import com.example.fastfizzabackend.model.entity.Order;
import com.example.fastfizzabackend.model.entity.User;
import com.example.fastfizzabackend.model.mapper.CartMapper;
import com.example.fastfizzabackend.model.mapper.OrderMapper;
import com.example.fastfizzabackend.repo.CartRepo;
import com.example.fastfizzabackend.repo.ItemRepo;
import com.example.fastfizzabackend.repo.OrderRepo;
import com.example.fastfizzabackend.repo.UserRepo;
import com.example.fastfizzabackend.service.OrderService;
import com.example.fastfizzabackend.utils.RoleName;
import lombok.AllArgsConstructor;
import lombok.extern.flogger.Flogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
	final private UserRepo userRepo;
	//    final private CartRepo cartRepo;
	final private OrderRepo orderRepo;
	final private CartMapper cartMapper;
	final private OrderMapper orderMapper;

	@Override
	public Long createOrder(OrderDTO orderDTO) {
		// Create customer (check customer is already exist by phone number)
		User user = userRepo.findByPhone(orderDTO.getPhone())
				.orElse(
						User.builder()
								.username(orderDTO.getUsername())
								.phone(orderDTO.getPhone())
								.roleName(RoleName.CUSTOMER)
								.address(orderDTO.getAddress())
								.build()
				);

		//Create Order
		Order order = new Order();
		order.setTotalPrice(orderDTO.getTotalPrice());
		order.setPriority(orderDTO.getPriority());
		order.setPriorityPrice(orderDTO.getPriorityPrice() == null ? 0 : orderDTO.getPriorityPrice());
		order.setUser(user);
		order.setCarts(
				orderDTO.getCartDTOS().stream()
						.map(cartDTO -> {
							Cart cart = cartMapper.mapToCart(cartDTO);
							cart.setOrder(order);
							return cart;
						})
						.collect(Collectors.toList())
		);

		// save order
		Order saveOrder = orderRepo.save(order);

		return saveOrder.getId();
	}

	@Override
	@Transactional(readOnly=true)
	public OrderDTO getOrderById(Long orderId) {
		Order order = orderRepo.findOrderById(orderId).orElseThrow(() -> new EntityNotFoundException("Something wrong with your order id: " + orderId));


		return orderMapper.mapToOrderDTO(order);
	}
}