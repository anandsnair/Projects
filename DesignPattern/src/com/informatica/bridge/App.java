package com.informatica.bridge;
/**
 * This is used to decouple an abstraction from its implementation so that two can
 * vary independently.
 * This pattern involves an interface which acts as a bridge which makes the 
 * functionality of concrete classes independent from interface implementer classes. 
 * Both types of classes can be altered structurally without affecting each other.
 * 
 * @author anair
 *
 */
public class App {

	public static void main(String[] args) {
		Shape redCircle = new Circle(new RedCircle());
		redCircle.draw();
		
		Shape greenCircle = new Circle(new GreenCircle());
		greenCircle.draw();
	}
}
