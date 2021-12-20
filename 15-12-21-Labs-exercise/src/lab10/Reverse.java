package lab10;

public class Reverse {

	public static void main(String[] args) {

		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*11);
		}
		for (int i : array) {
			System.out.print(i + ", ");
		}
		System.out.println();
		int[] reverse = new int[array.length];

		// locate all unique numbers
		int x = (array.length - 1);
		for (int i = 0; i < array.length; i++) {
			reverse[x] = array[i];
			x--;
		}
		for (int i = 0; i < reverse.length; i++) {
			System.out.print(reverse[i] + ", ");
		}
		System.out.println();
	}

}
