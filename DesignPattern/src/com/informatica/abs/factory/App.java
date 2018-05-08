package com.informatica.abs.factory;

import com.informatica.factory.Color;
import com.informatica.factory.ColorNotFoundException;
import com.informatica.factory.Shape;
import com.informatica.factory.ShapeNotFoundException;

/**
 * In Abstract factory an interface is responsible for creating a factory of related objects
 * 
 * @author anair
 *
 */
public class App {

	public static void main(String[] args) throws ShapeNotFoundException, ColorNotFoundException {
	      AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

	      Shape shape = shapeFactory.getShape("CIRCLE");
	      shape.draw();
	      AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
	      
	      Color color = colorFactory.getColor("BLUE");
	      color.fill();

	}
}
