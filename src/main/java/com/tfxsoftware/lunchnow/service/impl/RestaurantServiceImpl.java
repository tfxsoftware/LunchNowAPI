package com.tfxsoftware.lunchnow.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfxsoftware.lunchnow.entity.Restaurant;
import com.tfxsoftware.lunchnow.repository.RestaurantRepository;
import com.tfxsoftware.lunchnow.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public Restaurant saveRestaurant(Restaurant Restaurant) {
		return restaurantRepository.save(Restaurant);
	}

	@Override
	public List<Restaurant> getRestaurants() {
		return restaurantRepository.findAll();
	}

	@Override
	public Restaurant updateRestaurant(String id, Restaurant Restaurant) {
		Optional<Restaurant> findById = restaurantRepository.findById(id);
		if (findById.isPresent()) {
			Restaurant restaurantEntity = findById.get();
			if (Restaurant.getName() != null && !Restaurant.getName().isEmpty())
				restaurantEntity.setName(Restaurant.getName());
			if (Restaurant.getEmail() != null && !Restaurant.getEmail().isEmpty())
				restaurantEntity.setEmail(Restaurant.getEmail());
			if (Restaurant.getPassword() != null && !Restaurant.getPassword().isEmpty())
				restaurantEntity.setPassword(Restaurant.getPassword());
			if (Restaurant.getRestaurantImgUrl() != null && !Restaurant.getRestaurantImgUrl().isEmpty())
				restaurantEntity.setRestaurantImgUrl(Restaurant.getRestaurantImgUrl());
			if (Restaurant.getCnpj() != null && !Restaurant.getCnpj().isEmpty())
				restaurantEntity.setCnpj(Restaurant.getCnpj());
			if (Restaurant.getLocal() != null && !Restaurant.getLocal().isEmpty())
				restaurantEntity.setLocal(Restaurant.getLocal());
			
				return restaurantRepository.save(restaurantEntity);

		}
		return null;
	}

	@Override
	public void deleteRestaurant(String id) {
		restaurantRepository.deleteById(id);
	}

	public Restaurant getARestaurant(String id){
		Optional<Restaurant> findById = restaurantRepository.findById(id);
		return findById.get();
	}
}

