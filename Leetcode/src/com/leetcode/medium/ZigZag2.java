package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZigZag2 {
	public static void main(String[] args) {
		ZigZag2 zig = new ZigZag2();
		System.out.println(zig.convert("A", 4));
	}
	
	public String convert(String s, int numRows) {
        Map<Integer, List<Character>> mapOfRowToString = new HashMap<Integer, List<Character>>();
        int travi = 0;
        boolean goDown = true;
        if(s.isEmpty() || numRows ==1) {
            return s;
        }
        for(int i  = 0 ; i < s.length() ; i++) {
            if(travi >= 0 && travi < numRows && goDown) {
            	insertValue(mapOfRowToString, travi, s, i);
            	travi++;
            } else {
                goDown = false;
                if(travi == numRows) {
                	travi = numRows-1;
                }
            	travi--;
            	insertValue(mapOfRowToString, travi, s, i);
                if(travi == 0) {
                    goDown = true;
                    travi++;
                }
            }
        }
        StringBuilder bldr = new StringBuilder();
        for(int i = 0 ; i < numRows ; i++) {
        	if(mapOfRowToString.get(i) != null) {
            	for(Character ch : mapOfRowToString.get(i)) {
                	bldr.append(ch);
            	}
        	}
        }
        return bldr.toString();
    }
	
	public void insertValue(Map<Integer, List<Character>> mapOfRowToString, int travi, String s, int i) {
    	if(!mapOfRowToString.containsKey(travi)) {
    		List<Character> ch = new ArrayList<Character>();
    		ch.add(s.charAt(i));
    		mapOfRowToString.put(travi, ch);
    	} else {
    		mapOfRowToString.get(travi).add(s.charAt(i));
    	}

	}

}
