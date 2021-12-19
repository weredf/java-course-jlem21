package lab10;

public class MoreArrays {

	public static void main(String[] args) {

		int[] arraystat = { 1, 2, 3, 1, 2, 3, 3, 2, 1, 9, 5, 1, 1, 9 };

		// print instances of value 3 and value 1
		int c1 = 0;
		int c2 = 0;
		for (int i = 0; i < arraystat.length; i++) {
			if (arraystat[i] == 3) {
				c1++;
			} else if (arraystat[i] == 1) {
				c2++;
			}
		}
		System.out.println("The number 3 occurs " + c1 + " times.");
		System.out.println("The number 1 occurs " + c2 + " times.");

	}

}
