package com.informatica.composite;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	String name;
	String dept;
	int salary;
	List<Employee> subordinates = new ArrayList<Employee>();
	
	Employee(String name, String dept, int salary) {
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	public void addSubordinate(Employee subordinate) {
		subordinates.add(subordinate);
	}
	
	public void removeSubordinte(Employee subordinate) {
		subordinate.removeSubordinte(subordinate);
	}
	
	   public String toString(){
		      return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary+" ]");
		   }   

	
}
