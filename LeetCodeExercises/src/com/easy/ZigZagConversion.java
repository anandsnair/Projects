package com.easy;

public class ZigZagConversion {

	public static void main(String[] args) {
		ZigZagConversion convertor = new ZigZagConversion();
		System.out.println(convertor.convert("PAYPALISHIRING", 3));
		
	}
	
	public String convert(String s, int rows) {
		int difference = 2*rows - 2;
		String result = "";
		for(int i = 0 ; i < rows ; i++) {
			int currentIndex = i;
			boolean odd = true;
			if(i == 0 || i == rows-1) {
				odd = false;
			}
			while(currentIndex < s.length()) {
				result = result+s.charAt(currentIndex);
				if(odd) {
					currentIndex = currentIndex + 2*((rows-1)-i);
					odd = false;
				} else {
					if(i == 0 || i == rows-1) {
						currentIndex = currentIndex + difference;
					}
					else {
						currentIndex = currentIndex + difference - 2*((rows-1)-i);
						odd = true;
					}
				}
			}
		}
		return result;
	}
}
