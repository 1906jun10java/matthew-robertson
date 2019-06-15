package com.revature.codingchallenge;
import java.util.Scanner;  // Import the Scanner class

public class Main {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter first number for calculation: ");
		double firstNumber = myObj.nextDouble();
		System.out.println("Enter operation type: +, -, *, or / ");
		char operation = myObj.next().charAt(0);
		System.out.println("Enter second number for calculation: ");
		double secondNumber = myObj.nextDouble();
		
		Calculator c = new Calculator();
		double result;
		
		if(operation == '+') {
			result = c.add(firstNumber, secondNumber);
			System.out.println(result);
		}else if(operation == '-') {
			result = c.subtract(firstNumber, secondNumber);
			System.out.println(result);
		}else if(operation == '*') {
			result = c.multiply(firstNumber, secondNumber);
			System.out.println(result);
		}else if(operation == '/') {	
			result = c.divide(firstNumber, secondNumber);
			System.out.println(result);
		}
		
	}

}
