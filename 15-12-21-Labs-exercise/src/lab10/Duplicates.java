package lab10;

public class Duplicates {

	public static void main(String[] args) {

		int[] duplicate = { 1, 2, 5, 1, 6, 1, 5, 4, 8 };
		int[] unique = new int[duplicate.length];

		// locate all unique numbers

		for (int i = 0; i < duplicate.length; i++) {
			unique[i] = duplicate[i];
			for (int j = 0; j < duplicate.length; j++) {
				if (unique[j] == duplicate[i] && j != i) {
					unique[i] = 0;
				}
			}
		}
		for (int i = 0; i < unique.length; i++) {
			System.out.print(unique[i]);
		}
		System.out.println();
		
		// eliminate 0
		for (int i = 0; i < unique.length; i++) {
			while(unique[i]==0) {
				unique[i]=unique[i++];
			}
		System.out.print(unique[i]);		
		}

	}

}
