package com.informatica.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	List<Item> items = new ArrayList<Item>();
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public float getCost() {
		float price = 0;
		for(Item item : items) {
			price+=item.getPrice();
		}
		return price;
	}
	
	public void showItems() {
		for(Item item : items) {
			System.out.println(item.getName());
		}

	}
}
