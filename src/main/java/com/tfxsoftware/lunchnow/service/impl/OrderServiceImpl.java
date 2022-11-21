package com.tfxsoftware.lunchnow.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfxsoftware.lunchnow.entity.Meal;
import com.tfxsoftware.lunchnow.entity.Order;
import com.tfxsoftware.lunchnow.repository.OrderRepository;
import com.tfxsoftware.lunchnow.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository restaurantRepository;


	@Override
	public Order saveOrder(Order order) {
		order.setOrderDate(LocalDateTime.now());
		return restaurantRepository.save(order);
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

