package com.medium;

/**
 * Length of the longest substring without repeating characters
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA”
 and “DEFGAB”, with length 6. For “BBBB” the longest substring is “B”, with length 1. 
 For “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7.
 * @author anair
 *
 */
public class LengthOfLongestSubstringWithoutRepeatingChars {

	public static void main(String[] args) {
		LengthOfLongestSubstringWithoutRepeatingChars inst = new LengthOfLongestSubstringWithoutRepeatingChars();
		System.out.println(inst.longestSubString("GEEKSFORGEEKS"));
	}
	public int longestSubString(String str) {
		int[] visited = new int[256];
		int maxLength = 0;
		int currentLength = 0;
		int prevIndex = 0;
		for(int i = 0 ; i < 256; i++) {
			visited[i] = -1;
		}
		//Visit first character.
		visited[str.charAt(0)] = 0;
		currentLength = 1;
		maxLength = 1;
		for(int i = 1 ; i < str.length() ; i++) {
			prevIndex = visited[str.charAt(i)];
			if(visited[str.charAt(i)] == -1 || i - currentLength > prevIndex) {
				//Not visited or the character is not the part of the current sequence.
				currentLength++;
				visited[str.charAt(i)] = i;
			} else {
				//Visited
				//Check if the current character is part of the
				//current substring.
				if(currentLength>maxLength) {
					maxLength = currentLength;
				}
				currentLength = i-prevIndex;
				visited[str.charAt(i)] = i;

			}
		}
		if(currentLength>maxLength) {
			maxLength = currentLength;
		}
		return maxLength;
	}
}
