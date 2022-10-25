package com.tfxsoftware.lunchnow.service;

import java.util.List;

import com.tfxsoftware.lunchnow.entity.Meal;


public interface MealService {

	public Meal saveMeal(Meal meal);

	public List<Meal> getMealsByRestaurant(String Idr);

	public Meal updateMeal(String id, Meal meal);

	public void deleteMeal(String id);

	public Meal getAMeal(String id);

	
}