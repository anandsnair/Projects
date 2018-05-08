package com.algorithms.implementations;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Sherlock Holmes is getting paranoid about Professor Moriarty, his arch-enemy. 
 * All his efforts to subdue Moriarty have been in vain. These days Sherlock is working 
 * on a problem with Dr. Watson. Watson mentioned that the CIA has been facing weird problems 
 * with their supercomputer, 'The Beast', recently.
 * This afternoon, Sherlock received a note from Moriarty, saying that he has 
 * infected 'The Beast' with a virus. Moreover, the note had the number N printed on it. 
 * After doing some calculations, Sherlock figured out that the key to remove the virus 
 * is the largest Decent Number having N digits.
 * A Decent Number has the following properties:
 * 3, 5, or both as its digits. No other digit is allowed.
 * Number of times 3 appears is divisible by 5.
 * Number of times 5 appears is divisible by 3.
 * Meanwhile, the counter to the destruction of 'The Beast' is running very fast. 
 * Can you save 'The Beast', and find the key before Sherlock?
 */
public class SherlockAndTheBeast {

	public static void main(String[] args) {
		Scanner input = new Scanner(new InputStreamReader(System.in));
		int testcases = input.nextInt();
		for(int i = 0 ; i < testcases ; i++) {
			int nDigitNumber = input.nextInt();
			if(nDigitNumber <3) {
				System.out.print(-1);
			} else if(nDigitNumber%3 == 0) {
				//We can print all the digits to be 5
				String five  = new String(new char[nDigitNumber]).replace("\0", "5");
				System.out.print(five);
				/*for(int j= 0; j< nDigitNumber ; j++) {
					System.out.print(5);
				}*/
			} else if(nDigitNumber%3 !=0) {
				//It can be a mix of 5 and 3 or just 3
				int remaining = nDigitNumber%3;
				//this can be either 1 or 2.
				//if it is 2, then
				if(remaining == 2) {
					int nOf5 = (nDigitNumber) -5;
					int nOf3 = 5;
					String five  = new String(new char[nOf5]).replace("\0", "5");
					String three = new String(new char[nOf3]).replace("\0", "3");
					System.out.print(five+three);
				} else if(remaining == 1) {
					int nOf5 = (nDigitNumber) -10;
					int nOf3 = 10;
					if(nOf5 < 0) {
						System.out.print(-1);
					} else {
						String five  = new String(new char[nOf5]).replace("\0", "5");
						String three = new String(new char[nOf3]).replace("\0", "3");
						System.out.print(five+three);

					}
				}
			} else if(nDigitNumber%5 == 0) {
				//We can print all the digits to be 3
				//This has greatly improved performance instead of iterating through all the digits.
				String three = new String(new char[nDigitNumber]).replace("\0", "3");
				System.out.print(three);

				/*for(int j= 0; j< nDigitNumber ; j++) {
					System.out.print(3);
				}*/
			} 
			System.out.println();
		}
		
	}
	
}
