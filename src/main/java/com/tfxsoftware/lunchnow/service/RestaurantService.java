package com.tfxsoftware.lunchnow.service;

import java.util.List;

import com.tfxsoftware.lunchnow.entity.Restaurant;


public interface RestaurantService {

	public Restaurant saveRestaurant(Restaurant restaurant);

	public List<Restaurant> getRestaurants();

	public Restaurant updateRestaurant(Long id, Restaurant restaurant);

	public void deleteRestaurant(Long id);

	public Restaurant getARestaurant(long id);

	
}