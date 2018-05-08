package com.informatica.bridge;

public class Circle extends Shape {

	public Circle(DrawAPI drawAPI) {
		super(drawAPI);
	}

	@Override
	public void draw() {
		drawAPI.drawCircle();
	}

}
