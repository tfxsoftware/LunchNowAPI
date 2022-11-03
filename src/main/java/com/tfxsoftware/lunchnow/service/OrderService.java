package com.tfxsoftware.lunchnow.service;

import java.util.List;

import com.tfxsoftware.lunchnow.entity.Order;


public interface OrderService {

	public Order saveOrder(Order order);

	public List<Order> getOrders();

	public Order updateOrder(String id, Order order);

	public void deleteOrder(String id);

	public Order getAOrder(String id);

	public List<Order> getOrdersByRestaurant (String idr);

	public List<Order> getOrdersByUser (String Idu);

	
}