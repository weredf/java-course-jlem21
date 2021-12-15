package Lab2;

public class EvenOdd {

	public static void main(String[] args) {
		int num = (int) (Math.random() * 101);
		if (num <= 50) {
			System.out.println("Small!");
		} else {
			System.out.println("Big!");
		} 
		if (num%2==0) {
			System.out.println("Even");
		}else {
			System.out.println("Odd");
		}

	}

}
