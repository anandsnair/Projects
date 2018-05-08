package com.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum sum = new TwoSum();
		int[] input = new int[4];
		input[0] = -3;
		input[1] = 4;
		input[2] = 3;
		input[3] = 90;
		int[]	output = sum.twoSum(input, 0);
		System.out.println(output[0]);
	}
	 
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapOfValueToArrayIndex = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++) {
            if(mapOfValueToArrayIndex.containsKey(nums[i])) {
                int[] output = new int[2];
                output[0] = mapOfValueToArrayIndex.get(nums[i]);
                output[1] = i;
                return output;
            } else {
                mapOfValueToArrayIndex.put(target-nums[i],i);
            }
        }
        return new int[1];
    }
}

