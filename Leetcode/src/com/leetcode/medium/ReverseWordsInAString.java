package com.leetcode.medium;

import java.util.Scanner;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		System.out.println(reverseInput(input));
		
	}

	private static String reverseInput(String input) {
		String output = "";
		String everyWord = "";
		for(int i = 0 ; i<input.length() ;i++) {
			if(input.charAt(i) != ' ') {
				everyWord = everyWord + input.charAt(i);
			} else {
				output = " "+everyWord + output ;
				everyWord = "";
			}
		}
		output = " "+everyWord + output ;
		return output;
	}
}
