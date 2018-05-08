package com.test;

public class JavaTester {

	public static void main(String[] args) {
		MathOperation addition = (a,b) -> a+b;
		MathOperation subtraction = (a,b) ->a-b;
		
		JavaTester tester = new JavaTester();
		System.out.println(tester.operate(5,6,addition));
		System.out.println(tester.operate(6, 2, subtraction));
	}

	private int operate(int a, int b, MathOperation operation) {
		return operation.operation(a, b);
	}
}

