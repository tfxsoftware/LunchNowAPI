package com.tfxsoftware.lunchnow.service;

import java.util.List;

import com.tfxsoftware.lunchnow.entity.Restaurant;


public interface RestaurantService {

	public Restaurant saveRestaurant(Restaurant restaurant);

	public List<Restaurant> getRestaurants();

	public Restaurant updateRestaurant(String id, Restaurant restaurant);

	public void deleteRestaurant(String id);

	public Restaurant getARestaurant(String id);

	
}