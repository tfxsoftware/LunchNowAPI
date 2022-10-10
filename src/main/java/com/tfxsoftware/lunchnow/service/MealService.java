package com.tfxsoftware.lunchnow.service;

import java.util.List;

import com.tfxsoftware.lunchnow.entity.Meal;


public interface MealService {

	public Meal saveMeal(Meal meal);

	public List<Meal> getMealsByRestaurant();

	public Meal updateMeal(Long id, Meal meal);

	public void deleteMeal(Long id);

	public Meal getAMeal(long id);

	
}