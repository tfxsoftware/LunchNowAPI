package com.tfxsoftware.lunchnow.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfxsoftware.lunchnow.entity.Meal;
import com.tfxsoftware.lunchnow.repository.MealRepository;
import com.tfxsoftware.lunchnow.service.MealService;

@Service
public class MealServiceImpl implements MealService {

	@Autowired
	private MealRepository mealRepository;

	@Override
	public Meal saveMeal(Meal Meal) {
		return mealRepository.save(Meal);
	}


	@Override
	public Meal updateMeal(String id, Meal Meal) {
		Optional<Meal> findById = mealRepository.findById(id);
		if (findById.isPresent()) {
			Meal mealEntity = findById.get();
			if (Meal.getName() != null && !Meal.getName().isEmpty())
				mealEntity.setName(Meal.getName());
			if (Meal.getPrice() != null && Meal.getPrice() != 0)
				mealEntity.setPrice(Meal.getPrice());
			if (Meal.getMealImgUrl() != null && !Meal.getMealImgUrl().isEmpty())
				mealEntity.setMealImgUrl(Meal.getMealImgUrl());
			return mealRepository.save(mealEntity);
		}
		return null;
	}

	@Override
	public void deleteMeal(String id) {
		mealRepository.deleteById(id);
	}

	public List<Meal> getAMeal(String id){
		List<Meal> ret = new ArrayList<Meal>();
		Optional<Meal> findById = mealRepository.findById(id);
		ret.add(findById.get());
		return ret;
	}

    @Override
    public List<Meal> getMealsByRestaurant(String Idr) {
        List<Meal> ret = new ArrayList<>();
		List<Meal> list = mealRepository.findAll();
		Iterator<Meal> cursor = list.iterator();
		while (cursor.hasNext()){
			Meal current = cursor.next();
			if (current.getIdr().equals(Idr)) ret.add(current);
		}
		return ret;
    }
}

