package com.search;

public class MergeSort {

	int array[];
	int mergedArray[];
	
	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		sort.array = new int[]{1,3,7,65,3,2,1,9,5,6};
		sort.mergedArray = new int[sort.array.length];
		sort.partition(0, sort.array.length-1);
		sort.printArray(sort.mergedArray);
	}
	
	private void printArray(int[] array) {
		System.out.println();
		for(int i = 0 ; i < array.length ;i++) {
			System.out.print(array[i]+",");
		}
	}

	
	public void partition(int low, int high) {
		if(low<high) {
			int mid = low +(high-low)/2;
			partition(low, mid);
			partition(mid+1, high);
			merge(low, mid, high);
		}
	}

	public void merge(int low, int mid, int high) {
		int i = low;
		int j = mid+1;
		int k = low;
		while(i<low && j <high) {
			if(array[i]<array[j]) {
				mergedArray[k++] = array[i++];
			} else if(array[i]>=array[j]) {
				mergedArray[k++] = array[j++];
			}
		}
		while(i <= mid) {
			mergedArray[k++] = array[i++];
		} 
		while(j < high) {
			mergedArray[k++] = array[j++];
		}
	}
}
