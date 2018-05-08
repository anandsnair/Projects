package com.leetcode.medium;

public class ZigZag {

	public static void main(String[] args) {
		ZigZag zig = new ZigZag();
		System.out.println(zig.convert("PAYPALISHIRING", 4));
	}
	public String convert(String s, int numRows) {
        int columnLen = (s.length()/numRows) +1;
        char table[][] = new char[numRows][s.length()];
        int travi = 0;
        int travj = 0;
        boolean goDown = true;
        if(s.isEmpty() || numRows ==1) {
            return s;
        }
        for(int i  = 0 ; i < s.length() ; i++) {
            if(travi >= 0 && travi < numRows && goDown) {
                table[travi++][travj] = s.charAt(i);
            } else {
                goDown = false;
                if(travi == numRows) {
                	travi = numRows-1;
                	travj++;
                }
                if(travi == 0) {
                    goDown = true;
                    table[++travi][travj] = s.charAt(i);
                } else {
                    table[--travi][travj++] = s.charAt(i);
                }
            }
        }
        StringBuilder bldr = new StringBuilder();
        for(int i = 0 ; i < numRows ; i++) {
            for(int j = 0 ; j < columnLen ; j++) {
                //if(table[i][j] != '') {
                    bldr.append(table[i][j]);
                //}
            }
        }
        return bldr.toString();
    }
}
