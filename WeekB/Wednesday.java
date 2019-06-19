
public class Wednesday {

	public static void main(String [] args) {
		 
		reverse("Stanely Yelnats");
	}
	
		public static void reverse(String term) {
			char [] ys = term.toCharArray();
			for (int i = ys.length-1; i >= 0; i--) {
				System.out.print(ys[i]);
			}
		}
	
}
