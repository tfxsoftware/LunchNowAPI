package com.tfxsoftware.lunchnow.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfxsoftware.lunchnow.service.MealService;
import com.tfxsoftware.lunchnow.entity.Meal;
import com.tfxsoftware.lunchnow.entity.Order;
import com.tfxsoftware.lunchnow.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	private MealService mealService;
	
	@PostMapping("/save")
	public Order saveOrder(@RequestBody Order order) {
		float price = 0;
		Iterator<String> meals = order.getIdms().iterator();
		while(meals.hasNext()){
			Meal meal = mealService.getAMeal((String) meals.next());
			price = price + meal.getPrice();
		}
		order.setTotalPrice(Float.valueOf(price));
		return orderService.saveOrder(order);
	}
	
	
	@DeleteMapping("/delete/{order_id}")
	public String deleteOrder(@PathVariable("order_id") String id) {
		 orderService.deleteOrder(id);
		 return "Deleted succesfully.";
	}
	
	@GetMapping("/getorder/{order_id}")
	public Order getAOrder(@PathVariable("order_id") String id){
		return orderService.getAOrder(id);
	}

	@GetMapping("/getorderrestaurant/{restaurant_id}")
	public List<Order> getOrdersByRestaurant(@PathVariable("restaurant_id") String idr){
		return orderService.getOrdersByRestaurant(idr);
	}

	@GetMapping("/getorderuser/{user_id}")
	public List<Order> getOrdersByUser(@PathVariable("user_id") String idu){
		return orderService.getOrdersByRestaurant(idu);
	}
}
