package Lab4;

public class Number3 {

	public static void main(String[] args) {
		int numRan = (int) (Math.random() * 11);
		
		// print only even numbers from 0 until numRan
		for (int i = 0; i < numRan; i++) { 
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
		
		// print numRan only if even
		if (numRan%2==0) {
			System.out.println(numRan); 
		}
	}

}
