package Lab6;

public class Fibonacci2 {

	public static void main(String[] args) {
		int index = (int) (Math.random() * 10) + 1;
		int a1 = 1;
		int a2 = 1;
		System.out.println("Index: " + index);
		if (index == 1) {
			System.out.println("Fibonacci number: " + a1);
		}
		if (index == 2) {
			System.out.println("Fibonacci number: " + a2);
		}
		if (index > 2) {
			for (int i = 3; i <= index; i++) {
				int temp1 = a2;
				a2 = a2 + a1;
				a1 = temp1;
			}
			System.out.println("Fibonacci number: " + a2);
		}
	}

}
