package com.easy;

/**
 * 
 * @author anair
 *
 *Reverse digits of an integer.
 *Example1: x = 123, return 321
 *Example2: x = -123, return -321
 */
public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger instance = new ReverseInteger();
		System.out.println(instance.reverse(1534236469));
	}
	
	public int reverse(int number) {
		if(number < -2147483648 || number > 2147483647) {
			return 0;
		}
		long result = 0;
		boolean isNegative = false;
		if(number < 0) {
			isNegative = true;
			number = number*-1;
		}
		while(number > 0) {
			result = result *10 + number%10;
			number = number/10;
		}
		if(isNegative) {
			result = result * -1;
		}
		if(result < -2147483648 || result > 2147483647) {
			return 0;
		}

		return (int)result;
	}
}
