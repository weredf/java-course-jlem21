package lab4;

public class Factorial {

	public static void main(String[] args) {
		int numRan = (int) (Math.random() * 7) + 1;
		System.out.println(numRan);
		int fact = 1;
		
		// incremental for loop
		for (int i = 1; i <= numRan; i++) {
			fact = fact*i;
		}
			System.out.println(fact);
		
		// decremental for loop
		fact = 1;
		for (int i = numRan; i >= 1; i--) {
			fact = fact*i;
		}
			System.out.println(fact);
		
		// incremental while loop
		fact = 1;
		int c = 1;
		while (c <= numRan) {
			fact = fact*c;
			c++;
		}
		System.out.println(fact);
		
		// decremental while loop
		fact = 1;
		c = numRan;
		while (c >= 1) {
			fact = fact*c;
			c--;
		}
		System.out.println(fact);
	}

}
