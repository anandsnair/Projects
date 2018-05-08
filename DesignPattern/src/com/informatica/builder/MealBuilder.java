package com.informatica.builder;

public class MealBuilder {

	public static Meal createVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new DietCoke());
		return meal;
	}
	
	public static Meal createChickenMeal() {
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new DietCoke());
		return meal;
	}
	
}
