package lab10;

public class Duplicates {

	public static void main(String[] args) {

		int[] duplicate = { 1, 2, 5, 1, 6, 1, 5, 4, 8 };
		int[] unique = new int[duplicate.length];

		// locate all unique numbers

		for (int i = 0; i < duplicate.length; i++) {
			for (int j = 0; j < duplicate.length; j++) {
				if (unique[j] != duplicate[i] && j != i) {
					unique[j] = duplicate[j];
				}
			}

		}
		for (int i = 0; i < unique.length; i++) {
			System.out.println(unique[i]);
		}

	}

}
