package com.informatica.abs.factory;

import com.informatica.factory.Color;
import com.informatica.factory.ColorNotFoundException;
import com.informatica.factory.Shape;
import com.informatica.factory.ShapeNotFoundException;


public abstract class AbstractFactory {
	abstract Color getColor(String color) throws ColorNotFoundException;
	abstract Shape getShape(String shape) throws ShapeNotFoundException;
	
}
