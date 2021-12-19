package lab9;

public class MoreArrays2Bigger {

	public static void main(String[] args) {
		int[] ar = new int[10];
		ar[0] = (int) (Math.random() * 101);
		ar[1] = (int) (Math.random() * 101);
		ar[2] = (int) (Math.random() * 101);
		ar[3] = (int) (Math.random() * 101);
		ar[4] = (int) (Math.random() * 101);
		ar[5] = (int) (Math.random() * 101);
		ar[6] = (int) (Math.random() * 101);
		ar[7] = (int) (Math.random() * 101);
		ar[8] = (int) (Math.random() * 101);
		ar[9] = (int) (Math.random() * 101);

		// print all even elements
		for (int i = 0; i < 10; i++) {
			if (ar[i] % 2 == 0) {
				System.out.println(ar[i]);
			}
		}

		System.out.println("===============");

		// print all odd elements
		for (int i = 0; i < 10; i++) {
			if (ar[i] % 2 != 0) {
				System.out.println(ar[i]);
			}

		}
		System.out.println("===============");

		// print sum of even numbers
		int sum1 = 0;
		for (int i = 0; i < 10; i++) {
			if (ar[i] % 2 == 0) {
				sum1 += ar[i];
			}
		}
		System.out.println(sum1);
		System.out.println("===============");

		// print sum of odd numbers
		int sum2 = 0;
		for (int i = 0; i < 10; i++) {
			if (ar[i] % 2 != 0) {
				sum2 += ar[i];
			}
		}
		System.out.println(sum2);
		System.out.println("===============");

		// print which of the sums is bigger
		if (sum1 > sum2) {
			System.out.println(
					"The sum of even numbers (" + sum1 + ") is bigger than the sum of odd (" + sum2 + ") numbers.");
		} else {
			System.out.println(
					"The sum of odd numbers (" + sum2 + ") is bigger than the sum of even (" + sum1 + ") numbers.");
		}
	}

}
