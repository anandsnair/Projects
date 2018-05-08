package com.medium;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		
	}
	
	public int maxArea(int[] heights) {
		if (heights == null || heights.length < 2) {
			return 0;
		}

		int maxArea = 0;
		int left = 0;
		int right = heights.length-1;
		while(left < right) {
			maxArea = Math.max((right - left) * Math.min(heights[right],heights[left]), maxArea);
			if(heights[right] > heights[left]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}
}
