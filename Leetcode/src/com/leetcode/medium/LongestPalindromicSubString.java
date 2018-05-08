package com.leetcode.medium;

public class LongestPalindromicSubString {
	
	public static void main(String[] args) {
		LongestPalindromicSubString str = new LongestPalindromicSubString();
		System.out.println(str.longestPalindrome("abcba"));
	}
    public String longestPalindrome(String s) {
        int startIndex = 0;
        int maxLength = 1;
        int strLen = s.length();
        if(strLen == 1) {
            //Only one character
            return s;
        }
        boolean table[][] = new boolean[strLen][strLen];
        //Initialize the diagonal elements to be true
        for(int i = 0 ; i < strLen ; i++) {
            table[i][i] = true;
        }
        //Iterate over the array to find adjecent palindromes
        
        for(int i = 0 ; i < strLen-1 ; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                //This is palindrome
                table[i][i+1] = true;
                startIndex = i;
                maxLength = 2;
            }
        }
        
        for(int k = 3 ; k <= strLen ; k++) {
            for(int i = 0 ; i < strLen-k+1; i++) {
                int j = i+k-1;
                if(s.charAt(i) == s.charAt(j) && table[i+1][j-1] == true) {
                    maxLength = k;
                    startIndex = i;
                    table[i][j] = true;
                }
            }
        }
        return s.substring(startIndex, startIndex +maxLength);
    }

}
