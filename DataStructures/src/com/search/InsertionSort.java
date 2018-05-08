package com.search;

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort sortInstance = new InsertionSort();
		int[] array = {2,5,6,4,3,2,1,9,7,6};
		sortInstance.sort(array);
		sortInstance.printArray(array);
	}
	
	public void sort(int[] array) {
		for(int i=1;i<array.length;i++) {
			int key = array[i];
			int j = i-1;
			while(j >= 0 && array[j] > key) {
				array[j+1] = array[j];
				j = j-1;
			}
			array[j+1] = key;
		}
	}
	
	private void printArray(int[] array) {
		System.out.println();
		for(int i = 0 ; i < array.length ;i++) {
			System.out.print(array[i]+",");
		}
	}
}
