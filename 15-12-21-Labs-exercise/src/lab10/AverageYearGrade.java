package lab10;

public class AverageYearGrade {
	
	public static void main(String[] args) {
		
		// 20 students, each 10 grades
		int[][] matrix = new int[20][10];
		// populate with random grades 80-100	
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int)(Math.random()*21+80);
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=============================");
		
		int[] sum = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				sum[i] += matrix[i][j];
			}
			// print average from array sum (per student)
			int stud = (int)(sum[i]/matrix[i].length);
			System.out.println("Student average: " + stud);
			
		}
	}
}
