package lab8;

public class Arrays8 {

	public static void main(String[] args) {
		int[] arrr = new int[10];
		arrr[0] = (int) (Math.random() * 101);
		arrr[1] = (int) (Math.random() * 101);
		arrr[2] = (int) (Math.random() * 101);
		arrr[3] = (int) (Math.random() * 101);
		arrr[4] = (int) (Math.random() * 101);
		arrr[5] = (int) (Math.random() * 101);
		arrr[6] = (int) (Math.random() * 101);
		arrr[7] = (int) (Math.random() * 101);
		arrr[8] = (int) (Math.random() * 101);
		arrr[9] = (int) (Math.random() * 101);

		// print all elements on new line
		System.out.print("Elements of array: ");
		System.out.println(arrr[0] + ", " + arrr[1] + ", " + arrr[2] + ", " + arrr[3] + ", " + arrr[4] + ", " + arrr[5]
				+ ", " + arrr[6] + ", " + arrr[7] + ", " + arrr[8] + ", " + arrr[9]);

		// print total sum of elements
		System.out.print("Sum of array: ");
		int sum = arrr[0] + arrr[1] + arrr[2] + arrr[3] + arrr[4] + arrr[5] + arrr[6] + arrr[7] + arrr[8] + arrr[9];
		System.out.println(sum);

		// print average
		System.out.print("Average of elements: ");
		int avg = sum / arrr.length;
		System.out.println(avg);

		// print max element
		System.out.print("Max: ");
		int max = 0;
		for (int i = 0; i < arrr.length; i++) {
			if (arrr[i] > max) {
				max = arrr[i];
			}
		}
		System.out.println(max);

		// print index of max in the array
		System.out.print("Index max: ");
		for (int i = 0; i < arrr.length; i++) {
			if (arrr[i] == max) {
				System.out.println(i);
			}
		}

		// print min element
		System.out.print("Min: ");
		int min = 100;
		for (int i = 0; i < arrr.length; i++) {
			if (arrr[i] < min) {
				min = arrr[i];
			}
		}
		System.out.println(min);

		// print index of min in the array
		System.out.print("Index min: ");
		for (int i = 0; i < arrr.length; i++) {
			if (arrr[i] == min) {
				System.out.println(i);
			}
		}

	}

}
