package lab1;

public class Test {

	public static void main(String[] args) {
		int a = (int) (Math.random() * 101);
		int b = (int) (Math.random() * 101);
		System.out.println("a: " + a + "\t b: " + b);
		System.out.println("a + b: " + a + b);
		System.out.println("Sum: " + (a + b) / 2);
		System.out.println("Remainder a: " + (a % 10) + "\t Remainder b: " + (b % 10));
		System.out.println("Rectangle: " + a * b);
	}

}
