package com.crack.interview;

import java.util.Scanner;

public class MakingAnagrams {
	
    public static int numberNeeded(String first, String second) {
      int firstArray[] = new int[256];
      int secondArray[] = new int[256];
        initialize(firstArray);
        initialize(secondArray);
      for(int i = 0 ; i < first.length() ; i++) {
         char loc =  first.charAt(i);
          int ascii = (int)loc;
          firstArray[ascii] = firstArray[ascii]+1;
      }
      for(int i = 0 ; i < second.length() ; i++) {
         char loc =  second.charAt(i);
         int ascii = (int)loc;
         secondArray[ascii] = secondArray[ascii]+1;
      }
        return compareArray(firstArray, secondArray);
    }
     
    public static int compareArray(int[] first, int[] second) {
        int diff = 0;
        for(int i = 0 ; i < first.length ; i++) {
            if(first[i] != second[i]) {
            	if(first[i]-second[i] > 0) {
            		diff = diff + first[i]-second[i];
            	} else if(first[i]-second[i] < 0) {
            		diff = diff + second[i]-first[i];
            	}
            }
        }
        return diff;
    }

    public static void initialize(int[] array) {
        for(int i = 0 ; i < array.length ; i++) {
            array[i] = 0;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
