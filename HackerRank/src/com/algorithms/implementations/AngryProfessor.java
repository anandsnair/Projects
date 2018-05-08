package com.algorithms.implementations;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * The professor is conducting a course on Discrete Mathematics to a class of N students. 
 * He is angry at the lack of their discipline, and he decides to cancel the class if 
 * there are fewer than K students present after the class starts. Given the arrival 
 * time of each student, your task is to find out if the class gets cancelled or not.
 */
public class AngryProfessor {

	public static void main(String[] args) {
		//
		Scanner input = new Scanner(new InputStreamReader(System.in));
		int testcases = input.nextInt();
		for(int i = 0 ; i < testcases ; i++) {
			//
			int totalNumberOfStudents = input.nextInt();
			int minimumNumberOfStudents = input.nextInt();
			int count = 0;
			for(int j = 0 ; j < totalNumberOfStudents ; j++) {
				long time = input.nextLong();
				if(time <= 0) {
					count++;
				}
			}
			if(count < minimumNumberOfStudents) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
