
public class Utility {
	
	public static int minimumMutation(String start, String end) {
		boolean minimumMutation = false;
		char[] charArr = start.toCharArray();
		char[] charArr2 = end.toCharArray();
		int counter = 0;
		int x = 0;
		int y = charArr.length-1;
		
		while(x <= y){
			
			if(charArr[x] == charArr2[x]) {
				
				minimumMutation = true;
				
			} else {
				
				counter ++;
				minimumMutation = false;
			}
			
			x++;
		}
		return counter;
		
	}
}
