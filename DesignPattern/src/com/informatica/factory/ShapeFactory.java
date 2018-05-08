package com.informatica.factory;

public class ShapeFactory {
	
	public static Shape getShape(String shape) throws ShapeNotFoundException {
		if(shape.equals("RECTANGLE")) {
			return new Rectangle();
		} else if(shape.equals("SQUARE")) {
			return new Square();
		} else if(shape.equals("CIRCLE")) {
			return new Circle();
		} else {
			throw new ShapeNotFoundException(new Exception("Shape Not Found"));
		}
	}
}
