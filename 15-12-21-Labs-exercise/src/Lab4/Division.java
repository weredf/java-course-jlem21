package Lab4;

public class Division {

	public static void main(String[] args) {
		int max = (int) (Math.random() * 11);
		int den = (int) (Math.random() * 11);
		
		// print all numbers from 0 to max that divide by den
		for (int i = 0; i < max; i++) { 
			if (i % den == 0) {
				System.out.println(i);
			}
		}
		System.out.println(max);
		
	}

}
