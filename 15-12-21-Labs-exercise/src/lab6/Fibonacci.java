package lab6;

public class Fibonacci {

	public static void main(String[] args) {
		int a1 = 1;
		int a2 = 1;
		System.out.print(a1 + ", " + a2);
		for (int i = 3; i <= 40; i++) {
			int temp1 = a2;
			a2 = a2 + a1;
			a1 = temp1;
			System.out.print(", " + a2);

		}

	}

}
