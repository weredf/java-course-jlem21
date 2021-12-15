package Lab5;

public class MoreLoops {

	public static void main(String[] args) {
		int num = (int) (Math.random() * 10_001);
		System.out.println("Random number: " + num);
		// print length of digits
		int temp1 = num;
		int length = 0;
		while (temp1 > 0) {
			temp1 = (int) (temp1 / 10);
			length++;
		}
		System.out.println("Length: " + length);

		// print right digit
		int rd = (int) (num % 10);
		System.out.println("Right digit: " + rd);

		// print left digit
		int ld = 0;
		int temp2 = num;
		while (temp2 >= 10) {
			temp2 = temp2 / 10;
		}
		ld = temp2 % 10;
		System.out.println("Left digit: " + ld);

		// print opposite order of number digits and sum of digits
		int temp3 = num;
		int digit;
		int sum = 0;

		System.out.print("Opposite order: ");
		while (temp3 >= 10) {
			digit = (int) (temp3 % 10);
			sum = sum + digit;
			System.out.print(digit);
			temp3 = (int) (temp3 / 10);
		}
		sum = sum + temp3;
		System.out.println(temp3);
		System.out.println("Sum of digits: " + sum);

		// store opposite order in array, print if palindrome
		int[] pal = new int[length];
		int temp4 = num;
		int digit2 = 0;
		int i = 0;
		System.out.print("Opposite order: ");
		while (temp4 >= 10) {
			digit2 = (int) (temp4 % 10);
			pal[i] = digit2;
			temp4 = (int) (temp4 / 10);
			i++;
		}
		pal[i] = temp4;
		int in = 0;
		for (in = 0; in < pal.length; in++) {
			System.out.print(pal[in]);
		}
		System.out.println();
		System.out.print("Palindrome: ");
//		if (pal[in] == num) {
//		System.out.println("Yes");
//		} else {
//			System.out.println("No");
//		}

	}

}
