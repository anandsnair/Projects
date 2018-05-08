package com.informatica.builder;
/**
 * Builder pattern builds complex object using simple objects using step by step approach.
 * 
 * @author anair
 *
 */

public class BuilderPatternDemo {

	public static void main(String[] args) {
		Meal meal = MealBuilder.createChickenMeal();
		meal.showItems();
		System.out.println(meal.getCost());
	}
}
