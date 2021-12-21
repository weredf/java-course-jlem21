package f;

import java.util.Arrays;

public class ArrayCopy {

	public static void main(String[] args) {

		// declare array, use method to convert numbers to String in order to print
		// content
		int[] arr1 = { 2, 4, 6 };
		String str = Arrays.toString(arr1);
		System.out.println(str);

		// declare empty array and print
		int[] temp = new int[arr1.length + 2];
		System.out.println(Arrays.toString(temp));

		// method copies from one array to another the defined values in ()
		System.arraycopy(arr1, 1, temp, 1, arr1.length - 2);
		System.out.println(Arrays.toString(temp));

		// whatever is in arr1 will be gone and replaced by contents of temp
		arr1 = temp;
		System.out.println(Arrays.toString(arr1));

	}

}
