package com.revature.codingchallenge;

public class Calculator {
		// instance variables
		
		private double input1; 
		private double input2;
		
		// constructors
		public Calculator () {
		}
		
		// getters and setters
		
		public double getInput1() {
			return input1;
		}

		public void setInput1(double input1) {
			this.input1 = input1;
		}

		public double getInput2() {
			return input2;
		}

		public void setInput2(double input2) {
			this.input2 = input2;
		}
		
		
		// methods
		public double add (double input1, double input2) {
			double result = input1 + input2;
			return result;
			
		}
		
		public double subtract (double input1, double input2) {
			double result = input1 - input2;
			return result;
			
		}
		
		public double multiply (double input1, double input2) {
			double result = input1 * input2;
			return result;
			
		}
		
		public double divide (double input1, double input2) {
			double result = input1 / input2;
			return result;
			
		}
		
		
}
