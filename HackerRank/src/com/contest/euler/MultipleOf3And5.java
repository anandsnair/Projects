package com.contest.euler;

import java.util.Scanner;

public class MultipleOf3And5 {

	public static void main(String[] args) {
		int sum = 0;
		Scanner scan = new Scanner(System.in);
		int noOftestCases = scan.nextInt();
		for(int i = 0 ; i< noOftestCases; i++) {
			int n = scan.nextInt();
			n=n-1;
			int sumOf3 = sumOfMultiple(3, n);
			int sumOf5 = sumOfMultiple(5, n);
			int sumOf15 = sumOfMultiple(15, n);
			sum = sumOf3 + sumOf5 - sumOf15;
			System.out.println(sum);
			sum = 0;
		}
	}
	
	static int sumOfMultiple(int i, int n) {
		int sum = 0;
		if(n>=i) {
			int lastNum = n/i;
				sum = lastNum*(i+(lastNum*i))/2;
		}
		return sum;
	}
}
