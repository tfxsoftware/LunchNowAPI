package com.tfxsoftware.lunchnow.service.impl;

import java.util.List;
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
			return mealRepository.save(mealEntity);
		}
		return null;
	}

	@Override
	public void deleteMeal(String id) {
		mealRepository.deleteById(id);
	}

	public Meal getAMeal(String id){
		Optional<Meal> findById = mealRepository.findById(id);
		return findById.get();
	}

    @Override
    public List<Meal> getMealsByRestaurant(String Idr) {
        return null;
    }
}

