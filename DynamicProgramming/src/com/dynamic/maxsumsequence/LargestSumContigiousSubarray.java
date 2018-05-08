package com.dynamic.maxsumsequence;

public class LargestSumContigiousSubarray {

	public static void main(String[] args) {
		int[] intArray = {-2,-3,4,-1,-2,1,5,-3};
		System.out.println(findLargestSum(intArray));
	}

	private static int findLargestSum(int[] intArray) {
		int sumArray[] = new int[intArray.length];
		for(int i = 0 ; i < sumArray.length ; i++) {
			sumArray[i] = 0;
		}
		for(int i = 0 ; i < intArray.length ; i++) {
			if(i == 0) {
				if(intArray[i] > 0) {
					sumArray[i] = intArray[i];
				}
			} else {
				if(intArray[i] + sumArray[i-1] > 0 ) {
					sumArray[i] = intArray[i] + sumArray[i-1];
				} else {
					sumArray[i] = 0;
				}
			}
		}
		int maxSum = 0;
		for(int i = 0 ; i < sumArray.length ; i++) {
			if(maxSum < sumArray[i]) {
				maxSum = sumArray[i];
			}
		}
		return maxSum;
	}
	
	
}
