package com.informatica.factory;

public class FactoryPatternDemo {

	public static void main(String[] args) throws ShapeNotFoundException {
		ShapeFactory factory = new ShapeFactory();
		Shape shape = factory.getShape("CIRCLE");
		shape.draw();
		
		shape = factory.getShape("SQUARE");
		shape.draw();
	}
}
