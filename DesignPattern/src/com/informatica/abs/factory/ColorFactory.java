package com.informatica.abs.factory;

import com.informatica.factory.Color;
import com.informatica.factory.ColorNotFoundException;
import com.informatica.factory.Shape;

public class ColorFactory extends AbstractFactory {

	@Override
	Color getColor(String color) throws ColorNotFoundException {
		return com.informatica.factory.ColorFactory.getColor(color);
	}

	@Override
	Shape getShape(String shape) {
		return null;
	}


}
