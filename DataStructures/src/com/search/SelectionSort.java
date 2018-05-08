package com.search;

public class SelectionSort {

	public void sort(int[] array) {
		//The idea is to find the minimum number in one sub array 
		//swap with the maximum element of the sorted array.
		for(int i = 0 ; i < array.length ; i++) {
			int minIndex = i;
			for(int j = i+1; j < array.length; j++) {
				if(array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			int minNumber = array[minIndex];
			array[minIndex] = array[i];
			array[i] = minNumber;
		}
	}
	
	public static void main(String[] args) {
		SelectionSort instance = new SelectionSort();
		int[] array = {4,6,8,5,6,2,134,23,55,66,36,7,3,5};
		instance.sort(array);
		for(int i = 0; i < array.length ; i++) {
			System.out.print(array[i]+",");
		}
	}
	
	private void printArray(int[] array) {
		System.out.println();
		for(int i = 0 ; i < array.length ;i++) {
			System.out.print(array[i]+",");
		}
	}
}
