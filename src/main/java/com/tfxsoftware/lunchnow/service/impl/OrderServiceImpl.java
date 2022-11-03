package com.tfxsoftware.lunchnow.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
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

	@Override
	public List<Order> getOrdersByRestaurant(String idr) {
		List<Order> ret = new ArrayList<Order>();
		Iterator<Order> cursor = restaurantRepository.findAll().iterator();
		while (cursor.hasNext()){
			Order current = cursor.next();
			if (current.getIdr().equals(idr)) ret.add(current);
		}
		return ret;
	}

	@Override
	public List<Order> getOrdersByUser(String Idu) {
		List<Order> ret = new ArrayList<Order>();
		Iterator<Order> cursor = restaurantRepository.findAll().iterator();
		while (cursor.hasNext()){
			Order current = cursor.next();
			if (current.getIdr().equals(Idu)) ret.add(current);
		}
		return ret;
	}
}

