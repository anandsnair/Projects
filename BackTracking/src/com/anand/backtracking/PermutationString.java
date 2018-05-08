package com.anand.backtracking;

import java.util.Scanner;

/**
 * Write a program to print all permutations of a given string,
 * This solutin uses backtracking approach.
 * @author anair
 *
 */
public class PermutationString {

	public static void main(String[] args) {
		System.out.println("Please input the String ");
		Scanner scan = new Scanner(System.in);
		String inputString = scan.next();
		PermutationString permuteString = new PermutationString();
		permuteString.permute(inputString, 0, inputString.length()-1);
	}

	//Doing this with recursion approach
	private void permute(String inputString, int start, int end) {
		if(start == end) {
			System.out.println(inputString);
		}
		else {
			for(int i = start ; i <= end; i++) {
				System.out.println("start = "+start + " i = "+ i);
				inputString = swapString(inputString, start, i);
				permute(inputString, start+1, end);
				System.out.println("start = "+start + " i = "+ i);
				inputString = swapString(inputString, start, i);
			}
		}
	}

	private String swapString(String inputString, int i, int j) {
		char[] c = inputString.toCharArray();
		System.out.println("swapping "+c[i] +" with "+ c[j]);
		// Replace with a "swap" function, if desired:
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;

		String swappedString = new String(c);

		return swappedString;
	}
}
