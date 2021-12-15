package Lab6;

public class Fibonacci3 {

	public static void main(String[] args) {
		int val = (int) (Math.random() * 41) + 10;
		int a1 = 1;
		int a2 = 1;
		System.out.println(val);
		
		System.out.print(a1 + ", " + a2);
		for (int i = 3; a2 <= val; i++) {
			int temp1 = a2;
			a2 = a2 + a1;
			a1 = temp1;
			if (a2<=val) {
				System.out.print(", " + a2);
			}
		}
	}

}
