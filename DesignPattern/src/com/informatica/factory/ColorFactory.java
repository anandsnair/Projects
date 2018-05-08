package com.informatica.factory;

public class ColorFactory {

	public static Color getColor(String color) throws ColorNotFoundException {
		if(color.equals("RED")) {
			return new Red();
		} else if(color.equals("GREEN")) {
			return new Green();
		} else if(color.equals("BLUE")) {
			return new Blue();
		} else {
			throw new ColorNotFoundException(new Exception("Color not Found"));
		}
	}
}
