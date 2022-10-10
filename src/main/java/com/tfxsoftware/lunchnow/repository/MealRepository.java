package com.tfxsoftware.lunchnow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tfxsoftware.lunchnow.entity.Meal;


public interface MealRepository extends MongoRepository<Meal, Long> {

}