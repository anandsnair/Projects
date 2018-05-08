package com.easy;

public class PalindromeNumber {

	public static void main(String[] args) {
		PalindromeNumber num = new PalindromeNumber();
		System.out.println(num.isPalindrome(1221));
	}
	public boolean isPalindrome(int x) {
		int input = x;
		if(x < -2147483648 || x > 2147483647) {
			return false;
		}
		if(x<0)
			return false;
		long result = 0;
		boolean isNegative = false;
		if(x < 0) {
			isNegative = true;
			x = x*-1;
		}
		while(x > 0) {
			result = result *10 + x%10;
			x = x/10;
		}
		if(isNegative) {
			result = result * -1;
		}
		if(result < -2147483648 || result > 2147483647) {
			return false;
		}

		return (int)result==input;

	}
}
