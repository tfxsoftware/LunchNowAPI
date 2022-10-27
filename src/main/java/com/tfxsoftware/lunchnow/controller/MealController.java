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

import com.tfxsoftware.lunchnow.entity.Meal;
import com.tfxsoftware.lunchnow.service.MealService;

@RestController
@RequestMapping("/meal")
public class MealController {

	@Autowired
	private MealService mealService;
	
	@PostMapping("/save")
	public Meal saveMeal(@RequestBody Meal meal) {
		return mealService.saveMeal(meal);
	}
	
	@GetMapping("/list/{restaurant_id}")
	public List<Meal> getMeals(@PathVariable ("restaurant_id") String idr) {
		return mealService.getMealsByRestaurant(idr);
	}
	
	@PutMapping("/update/{meal_id}")
	public Meal updateMeal(@RequestBody Meal meal, @PathVariable("meal_id") String id) {
		return mealService.updateMeal(id, meal);
	}
	
	@DeleteMapping("/delete/{meal_id}")
	public String deleteMeal(@PathVariable("meal_id") String id) {
		 mealService.deleteMeal(id);
		 return "deleted succesfully.";
	}
	
	@GetMapping("/getmeal/{meal_id}")
	public Meal getAMeal(@PathVariable("meal_id") String id){
		return mealService.getAMeal(id);
	}
}
