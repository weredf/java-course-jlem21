package lab7;

public class LoopChar {

	public static void main(String[] args) {
		char[] arr = { 'a', 'b', 'c', 'a', 'b', 'd', 'r', 'c' };
		int c = 0;

		// count all 'a'
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'a') {
				c++;
			}
		}
		System.out.println(c);

		// count all 'a' and 'c'
		c = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'a' || arr[i] == 'c') {
				c++;
			}
		}
		System.out.println(c);

		String name = "John Bryce";
		char[] arrJB = name.toCharArray();

		// count all 'h' in John bryce
		c = 0;
		for (int i = 0; i < arrJB.length; i++) {
			if (arrJB[i] == 'h') {
				c++;
			}
		}
		System.out.println(c);
		
		String str = "Sara Shara Shir Sameach";
		char[] ssss = str.toCharArray();
		
		// count all vowels
		c = 0;
		for (int i = 0; i < ssss.length; i++) {
			if (ssss[i] == 'a' || ssss[i] == 'e' || ssss[i] == 'i' || ssss[i] == 'o' || ssss[i] == 'u') {
				c++;
			}
		}
		System.out.println(c);
	}

}
