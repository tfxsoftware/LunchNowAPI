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

import com.tfxsoftware.lunchnow.entity.Restaurant;
import com.tfxsoftware.lunchnow.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/save")
	public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantService.saveRestaurant(restaurant);
	}
	
	@GetMapping("/list")
	public List<Restaurant> getRestaurants() {
		return restaurantService.getRestaurants();
	}
	
	@PutMapping("/update/{restaurant_id}")
	public Restaurant updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable("restaurant_id") Long id) {
		return restaurantService.updateRestaurant(id, restaurant);
	}
	
	@DeleteMapping("/delete/{restaurant_id}")
	public String deleteRestaurant(@PathVariable("restaurant_id") Long id) {
		 restaurantService.deleteRestaurant(id);
		 return "deleted succesfully.";
	}
	
	@GetMapping("/getrestaurant/{restaurant_id}")
	public Restaurant getARestaurant(@PathVariable("restaurant_id") Long id){
		return restaurantService.getARestaurant(id);
	}
}
