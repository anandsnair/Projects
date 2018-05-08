package com.leetcode.medium;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		boolean negDividend = false;
		boolean negDivisor = false;
		if (dividend < 0) {
			negDividend = true;
			if(dividend == -2147483648)
			dividend = dividend - dividend - dividend;
		}
		if (divisor < 0) {
			negDivisor = true;
			divisor = -divisor - divisor + divisor;
		}
		if (dividend == divisor) {
			if (negDividend == negDivisor)
				return 1;
			else
				return -1;
		}
		int value = 0;
		int div = divisor;
		while (dividend > div) {
			div = div + divisor;
			value++;
		}
		if (negDividend == negDivisor)
			return value;
		else {
			value = -value - value + value;
		}
		return value;
	}

	public static void main(String[] args) {
		DivideTwoIntegers ins = new DivideTwoIntegers();
		System.out.println(ins.divide(-2147483648, -1));
	}
}