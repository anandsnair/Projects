package com.informatica.builder;

public abstract class ColdDrink implements Item {

	@Override
	public float getPrice() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Packing getPacking() {
		return new Bottle();
	}

}
