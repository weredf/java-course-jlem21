package lab2;

public class Bingo {

	public static void main(String[] args) {
		int num = (int) (Math.random() * 101);
		if (num > 50) {
			System.out.println("Big!");
		} else if (num < 50) {
			System.out.println("Small!");
		} else {
			System.out.println("Bingo!");
		}

	}

}
