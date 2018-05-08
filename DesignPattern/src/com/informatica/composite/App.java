package com.informatica.composite;

/**
 * Composite pattern is used to group a set of objects as a single object. Composite
 * pattern composes objects in term of a tree structure to represent a hierarchy.
 * @author anair
 *
 */
public class App {

	public static void main(String[] args) {
		Employee CEO = new Employee("Anil C", "CEO", 10000000);
	      Employee headSales = new Employee("Robert","Head Sales", 20000);
	      Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

	      Employee clerk1 = new Employee("Laura","Marketing", 10000);
	      Employee clerk2 = new Employee("Bob","Marketing", 10000);

	      Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
	      Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

	      CEO.addSubordinate(headSales);
	      CEO.addSubordinate(headMarketing);
	      headSales.addSubordinate(salesExecutive1);
	      headSales.addSubordinate(salesExecutive2);

	      headMarketing.addSubordinate(clerk1);
	      headMarketing.addSubordinate(clerk2);

	      //print all employees of the organization
	      System.out.println(CEO); 

	}
}
