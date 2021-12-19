package lab4;

public class Number2 {

	public static void main(String[] args) {
		int numRan1 = (int) (Math.random() * 11);
		int numRan2 = (int) (Math.random() * 11);
		
		// put biggest number first
		if (numRan1<numRan2) {
			int temp = numRan1;
			numRan1 = numRan2;
			numRan2 = temp;
		}
		
		// print all numbers from first to last
		for (int i = numRan1; i > numRan2; i--) {
			System.out.println(i);

		}
		System.out.println(numRan2);
	}

}
