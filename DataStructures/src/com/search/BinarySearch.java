package com.search;

public class BinarySearch {

	public int binarySearch(int[] intArray, int start, int end, int numberToSearch) {
		if(start <= end) {
			int mid = (start+end)/2;
			System.out.println("Start="+start + "End=" + end + "Mid=" +mid);
			if(intArray[mid] > numberToSearch) {
				//This means that the number to search exists in the left side of the array.
				return binarySearch(intArray, start, mid-1, numberToSearch);
			} else if(intArray[mid] < numberToSearch) {
				//This means that the number to search exists in the right side of the array.
				return binarySearch(intArray, mid+1, end, numberToSearch);
			} else {
				// numberToSearch found in the array.
				return intArray[mid];
			}
		} else {
			return 0;
		}
	}
	public static void main(String[] args) {
		BinarySearch search = new BinarySearch();
		int[] intArray = {2,4,5,6,7,8,9,10,11,15,18,20};
		System.out.println(search.binarySearch(intArray, 0, intArray.length-1, 20));
	}
}
