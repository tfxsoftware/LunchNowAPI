package com.tfxsoftware.lunchnow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfxsoftware.lunchnow.entity.Order;
import com.tfxsoftware.lunchnow.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/save")
	public Order saveOrder(@RequestBody Order order) {
		return orderService.saveOrder(order);
	}
	
	@GetMapping("/list")
	public List<Order> getOrders() {
		return orderService.getOrders();
	}
	
	@PutMapping("/update/{order_id}")
	public Order updateOrder(@RequestBody Order order, @PathVariable("order_id") String id) {
		return orderService.updateOrder(id, order);
	}
	
	@DeleteMapping("/delete/{order_id}")
	public String deleteOrder(@PathVariable("order_id") String id) {
		 orderService.deleteOrder(id);
		 return "deleted succesfully.";
	}
	
	@GetMapping("/getorder/{order_id}")
	public Order getAOrder(@PathVariable("order_id") String id){
		return orderService.getAOrder(id);
	}
}
