package com.revature.individualcodingchallenge;

public class FizzBuzz {
	
		public void fizzBuzzBasic() {
	
		for (int i = 1 ; i <= 100; i++) {

		if(i % 3 == 0 && i % 5 == 0) {
			System.out.println("fizzbuzz");
		}else if(i % 3 == 0) {
			System.out.println("fizz");
		}else if(i % 5 == 0) {
			System.out.println("buzz");
		}else if(i <= 100) {
			System.out.println(i);
			}
				
		}
		
	}
		
	public void fizzBuzzAdvanced(int range1, int range2, int [] numbers, String [] terms) {
		
		for(int i = range1 ; i < range2 ; i++) {
			if(i % numbers == 0 && i % divisor2 == 0) {
			 System.out.println(terms);
			}
				
			}
		}
	}
}

