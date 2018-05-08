package com.informatica.builder;

public abstract class Burger implements Item {

	@Override
	public float getPrice() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Packing getPacking() {
		return new Wrapper();
	}

}
