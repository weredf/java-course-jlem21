package lab9;

public class MoreArrays3Highest {

	public static void main(String[] args) {
		int[] ar50 = new int[50];
		ar50[0] = (int) (Math.random() * 101);
		ar50[1] = (int) (Math.random() * 101);
		ar50[2] = (int) (Math.random() * 101);
		ar50[3] = (int) (Math.random() * 101);
		ar50[4] = (int) (Math.random() * 101);
		ar50[5] = (int) (Math.random() * 101);
		ar50[6] = (int) (Math.random() * 101);
		ar50[7] = (int) (Math.random() * 101);
		ar50[8] = (int) (Math.random() * 101);
		ar50[9] = (int) (Math.random() * 101);
		ar50[10] = (int) (Math.random() * 101);
		ar50[11] = (int) (Math.random() * 101);
		ar50[12] = (int) (Math.random() * 101);
		ar50[13] = (int) (Math.random() * 101);
		ar50[14] = (int) (Math.random() * 101);
		ar50[15] = (int) (Math.random() * 101);
		ar50[16] = (int) (Math.random() * 101);
		ar50[17] = (int) (Math.random() * 101);
		ar50[18] = (int) (Math.random() * 101);
		ar50[19] = (int) (Math.random() * 101);
		ar50[20] = (int) (Math.random() * 101);
		ar50[21] = (int) (Math.random() * 101);
		ar50[22] = (int) (Math.random() * 101);
		ar50[23] = (int) (Math.random() * 101);
		ar50[24] = (int) (Math.random() * 101);
		ar50[25] = (int) (Math.random() * 101);
		ar50[26] = (int) (Math.random() * 101);
		ar50[27] = (int) (Math.random() * 101);
		ar50[28] = (int) (Math.random() * 101);
		ar50[29] = (int) (Math.random() * 101);
		ar50[30] = (int) (Math.random() * 101);
		ar50[31] = (int) (Math.random() * 101);
		ar50[32] = (int) (Math.random() * 101);
		ar50[33] = (int) (Math.random() * 101);
		ar50[34] = (int) (Math.random() * 101);
		ar50[35] = (int) (Math.random() * 101);
		ar50[36] = (int) (Math.random() * 101);
		ar50[37] = (int) (Math.random() * 101);
		ar50[38] = (int) (Math.random() * 101);
		ar50[39] = (int) (Math.random() * 101);
		ar50[40] = (int) (Math.random() * 101);
		ar50[41] = (int) (Math.random() * 101);
		ar50[42] = (int) (Math.random() * 101);
		ar50[43] = (int) (Math.random() * 101);
		ar50[44] = (int) (Math.random() * 101);
		ar50[45] = (int) (Math.random() * 101);
		ar50[46] = (int) (Math.random() * 101);
		ar50[47] = (int) (Math.random() * 101);
		ar50[48] = (int) (Math.random() * 101);
		ar50[49] = (int) (Math.random() * 101);
		
		// print all elements
		for (int i = 0; i < 50; i++) {
			System.out.println(ar50[i]);
		}
		System.out.println("===============");
		
		// print highest number
		int max = 0;
		for (int i = 0; i < ar50.length; i++) {
			if (ar50[i] > max) {
				max = ar50[i];
			}
		}
		System.out.println("The highest number in the array is: " + max);
		
		// print index number of highest number
		for (int i = 0; i < ar50.length; i++) {
			if (ar50[i] == max) {
				System.out.println("The index number of the highest number is: " + i);
			}
		}
	}
}
