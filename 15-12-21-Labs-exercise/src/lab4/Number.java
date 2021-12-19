package lab4;

public class Number {

	public static void main(String[] args) {
		int numRan = (int) (Math.random() * 11);
		
		// print all numbers from 1 to numRan
		for (int i = 1; i < numRan; i++) {
			System.out.println(i);

		}
		System.out.println(numRan);
	}

}
