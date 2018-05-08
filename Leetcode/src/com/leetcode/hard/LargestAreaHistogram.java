package com.leetcode.hard;

import java.util.Stack;

public class LargestAreaHistogram {
    public static int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            System.out.println("i="+i);

            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
            	System.out.println("Pushing "+i);
                s.push(i);
            }else{
                int tp = s.pop();
                System.out.println("Poping "+tp);
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
    
    public static void main(String[] args) {
		int[] numbers = {2,1,5,6,2,3,1,1,1,1,1};
		System.out.println(largestRectangleArea(numbers));
	}
}
