package com.search;

public class BubbleSort {
	public void sort(int array[]) {
		for(int i = 0 ; i < array.length-1 ; i++) {
			for(int j = 0 ; j < array.length-1-i ; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j+1];
					array[j+1] =array[j];
					array[j] = temp;
				}
			}
			printArray(array);
		}
	}

	private void printArray(int[] array) {
		System.out.println();
		for(int i = 0 ; i < array.length ;i++) {
			System.out.print(array[i]+",");
		}
	}
	
	public static void main(String[] args) {
		BubbleSort instance = new BubbleSort();
		int[] array = {3,4,6,5,4,2,1,9,8,75,6,7,4};
		instance.sort(array);
		instance.printArray(array);
	}
}
