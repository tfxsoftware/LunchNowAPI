package com.tfxsoftware.lunchnow.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
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
			if (Restaurant.getAddress() != null);
				restaurantEntity.setAddress(Restaurant.getAddress());
			
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

	public List<Restaurant> getRestaurantByType(String type){
		Iterator<Restaurant> cursor = restaurantRepository.findAll().iterator();
		List<Restaurant> listByType = new ArrayList<Restaurant>();
		while(cursor.hasNext()){
			Restaurant current = cursor.next();
			if (current.getType().equals(type)) listByType.add(current);
		}
	
	return listByType;
	}

	public List<Restaurant> getRestaurantByDistance(double x, double y){
		Iterator<Restaurant> cursor = restaurantRepository.findAll().iterator();
		List<Restaurant> listByDistance = new ArrayList<Restaurant>();
		while(cursor.hasNext()){
			Restaurant current = cursor.next();
			double xr = current.getAddress().getX();
			double yr = current.getAddress().getY();
			if (Math.sqrt(Math.pow(xr - x, 2)+Math.pow(yr - y, 2))<=0.03) listByDistance.add(current);
		}
		return listByDistance;
	}
}

