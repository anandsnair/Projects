package com.informatica.abs.factory;

import com.informatica.factory.Color;
import com.informatica.factory.Shape;
import com.informatica.factory.ShapeNotFoundException;


public class ShapeFactory extends AbstractFactory {

	@Override
	Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Shape getShape(String shape) throws ShapeNotFoundException {
		return com.informatica.factory.ShapeFactory.getShape(shape);
	}

}
