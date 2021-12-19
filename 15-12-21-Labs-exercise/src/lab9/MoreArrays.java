package lab9;

public class MoreArrays {

	public static void main(String[] args) {
		int[] arran = new int[10];
		arran[0] = (int) (Math.random() * 101);
		arran[1] = (int) (Math.random() * 101);
		arran[2] = (int) (Math.random() * 101);
		arran[3] = (int) (Math.random() * 101);
		arran[4] = (int) (Math.random() * 101);
		arran[5] = (int) (Math.random() * 101);
		arran[6] = (int) (Math.random() * 101);
		arran[7] = (int) (Math.random() * 101);
		arran[8] = (int) (Math.random() * 101);
		arran[9] = (int) (Math.random() * 101);

		// print all even elements
		for (int i = 0; i < 10; i++) {
			if (arran[i] % 2 == 0) {
				System.out.println(arran[i]);
			}
		}

		System.out.println("===============");

		// print all odd elements
		for (int i = 0; i < 10; i++) {
			if (arran[i] % 2 != 0) {
				System.out.println(arran[i]);
			}

		}
		System.out.println("===============");

		// print sum of even numbers
		int sum1 = 0;
		for (int i = 0; i < 10; i++) {
			if (arran[i] % 2 == 0) {
				sum1 += arran[i];
			}
		}
		System.out.println(sum1);
		System.out.println("===============");

		// print sum of odd numbers
		int sum2 = 0;
		for (int i = 0; i < 10; i++) {
			if (arran[i] % 2 != 0) {
				sum2 += arran[i];
			}
		}
		System.out.println(sum2);
		System.out.println("===============");
		
	}

}
