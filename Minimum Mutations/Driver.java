import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	
	public static void main(String [] args) {
		
		Utility util = new Utility();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter start mutation (must include only A, C, G, T)");
		String start = sc.nextLine();
		System.out.println("Enter end mutation (must include only A, C, G, T)");
		String end = sc.nextLine();

		System.out.println(util.minimumMutation(start,end));
		
		
	}

	
}
