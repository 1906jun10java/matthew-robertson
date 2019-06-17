package com.revature.individualcodingchallenge;

import java.util.Scanner;

public class Main {
	
		public static void main(String[] args) {
			
			FizzBuzz fb = new FizzBuzz();
			
			fb.fizzBuzzBasic();
			
			Scanner myObj = new Scanner(System.in);
			System.out.println("Enter first range ");
			int firstRange = myObj.nextInt();
			System.out.println("Enter second range ");
			int secondRange = myObj.nextInt();
			System.out.println("Enter desired divisors ");
			int [] divisors = myObj.nextInt();
			System.out.println("Enter desired terms ");
			String [] terms = myObj.next();
			fb.fizzBuzzAdvanced(firstRange, secondRange, divisors, terms);
			
		}
	
}
