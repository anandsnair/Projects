package com.leetcode.easy;

public class LargestNumber {

	public int reverselargestNumber(int number) {

		// Create an array with 0-9
		  if(number <0) {
		      number = number *-1;
		  }
		 int[] array = new int[10];
		 int numberOfDigits = 1;
		 //Divide the number and iterate over all the digits.
		 while(number>0) {
		     int digit = number%10;
		     //Store the digit in the array
		     array[digit] = array[digit]+1;
		     number = number/10;
		     numberOfDigits = numberOfDigits*10;
		 }
		 numberOfDigits = numberOfDigits/10;
		 int reversedNumber = 0;
		 for(int i = 9; i >0 ;i--){
		    // int multiplier = 1;
		     while(array[i] > 0) {
		         reversedNumber = (numberOfDigits * i) + reversedNumber;
		         numberOfDigits = numberOfDigits/10; 
		         array[i]=array[i]-1;
		     }
		 }
		 return reversedNumber;
		}
	
	public static void main(String[] args) {
		LargestNumber number = new LargestNumber();
		System.out.println(number.reverselargestNumber(-1));
	}
}
