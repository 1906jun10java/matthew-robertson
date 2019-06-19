
public class Wednesday {

	public static void main(String [] args) {
		 
		 reverse("StanelyYelnats");
		// calculateFactorial(7);
		// isPalindrome("StanleyYelnats");
	}
	
		public static void reverse(String term) {
			char [] ys = term.toCharArray();
			for (int i = ys.length-1; i >= 0; i--) {
				System.out.print(ys[i]);
			}
		}
	
		public static void isPalindrome(String term) {
			char[] ys = term.toCharArray();		
			for (int i = ys.length-1; i >= 0; i--) {
					char reverse = ys[i];
				}
					if(reverse == ys)
				}
		}
}		
		/*
		public static int calculateFactorial(int n) {
			// base case
			if(n == 0 || n == 1) {
				return 1;
				
			}else
			// recursion case
				return n * calculateFactorial(n-1);
		}
}*/


