package com.tfxsoftware.lunchnow.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfxsoftware.lunchnow.entity.Order;
import com.tfxsoftware.lunchnow.repository.OrderRepository;
import com.tfxsoftware.lunchnow.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository restaurantRepository;

	@Override
	public Order saveOrder(Order Order) {
		return restaurantRepository.save(Order);
	}

	@Override
	public List<Order> getOrders() {
		return restaurantRepository.findAll();
	}

	@Override
	public Order updateOrder(String id, Order Order) {
		Optional<Order> findById = restaurantRepository.findById(id);
		if (findById.isPresent()) {
			Order orderEntity = findById.get();
		}
		return null;
	}

	@Override
	public void deleteOrder(String id) {
		restaurantRepository.deleteById(id);
	}

	public Order getAOrder(String id){
		Optional<Order> findById = restaurantRepository.findById(id);
		return findById.get();
	}
}

