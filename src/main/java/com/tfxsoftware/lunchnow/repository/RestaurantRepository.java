package com.tfxsoftware.lunchnow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tfxsoftware.lunchnow.entity.Restaurant;


public interface RestaurantRepository extends MongoRepository<Restaurant, Long> {

}