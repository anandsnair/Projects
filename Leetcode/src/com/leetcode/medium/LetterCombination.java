package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.

 */
public class LetterCombination {

	
	private Map<String, ArrayList<String>> constuctPhoneKeyArray() {
		Map<String, ArrayList<String>> phoneNumberToAlphabets = new HashMap<String, ArrayList<String>>();
		ArrayList<String> alphabets = new ArrayList<String>();
		alphabets.add("a");
		alphabets.add("b");
		alphabets.add("c");
		phoneNumberToAlphabets.put("2", alphabets);
		alphabets = new ArrayList<String>();
		alphabets.add("d");
		alphabets.add("e");
		alphabets.add("f");
		phoneNumberToAlphabets.put("3", alphabets);
		alphabets = new ArrayList<String>();
		alphabets.add("g");
		alphabets.add("h");
		alphabets.add("i");
		phoneNumberToAlphabets.put("4", alphabets);
		alphabets = new ArrayList<String>();
		alphabets.add("j");
		alphabets.add("k");
		alphabets.add("l");
		phoneNumberToAlphabets.put("5", alphabets);
		alphabets = new ArrayList<String>();
		alphabets.add("m");
		alphabets.add("n");
		alphabets.add("o");
		phoneNumberToAlphabets.put("6", alphabets);
		alphabets = new ArrayList<String>();
		alphabets.add("p");
		alphabets.add("q");
		alphabets.add("r");
		alphabets.add("s");
		phoneNumberToAlphabets.put("7", alphabets);
		alphabets = new ArrayList<String>();
		alphabets.add("t");
		alphabets.add("u");
		alphabets.add("v");
		phoneNumberToAlphabets.put("8", alphabets);
		alphabets = new ArrayList<String>();
		alphabets.add("w");
		alphabets.add("x");
		alphabets.add("y");
		alphabets.add("z");
		phoneNumberToAlphabets.put("9", alphabets);
		return phoneNumberToAlphabets;
	}
	
	public static void main(String[] args) {
		
	}
	
	public List<String> letterCombinations(String digits) {
		Map<String, ArrayList<String>> phoneNumberToAlphabets = constuctPhoneKeyArray();

		List<String> output = new ArrayList<String>();
		for(int i = 0 ; i < digits.length() ; i++) {
			char num = digits.charAt(i);
		}
		return output;
	}
}
