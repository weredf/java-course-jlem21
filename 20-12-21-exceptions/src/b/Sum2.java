package b;

import java.util.Scanner;

public class Sum2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
			System.out.println("enter first number: ");
			int a = sc.nextInt();
//			int a = Integer.parseInt(sc.nextLine()); // option 1 to prevent endless loop
			System.out.println("enter second number: ");
			int b = sc.nextInt();
//			int b = Integer.parseInt(sc.nextLine()); // option 1 to prevent endless loop
			System.out.println(a + " + " + b + " = " + (a+b));
			break;
			} catch (Exception e) {
				System.out.println(sc.nextLine()); // option 2 to prevent endless loop
//				sc.nextLine(); // option 3 to prevent endless loop
				System.out.println("you entered wrong input, try again");
			}
		}
		
		sc.close();
		System.out.println(" ==end of program==");

		
	}

}
