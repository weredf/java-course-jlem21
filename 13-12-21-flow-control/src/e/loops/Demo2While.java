package e.loops;

import java.util.Scanner;

public class Demo2While {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int p = 123;
		System.out.print("Enter password: ");
		int input = sc.nextInt(); // input operation
		
		int attempts = 1;
		
		//===================================================
		while(input != p && attempts < 3) {
			System.out.println("Wrong password, try again: ");
			input = sc.nextInt(); // input operation
			attempts++;
		} 
		//===================================================
				
		sc.close();
		
		if(input == p) {
			System.out.println("Success!"); 
		} else {
			System.out.println("Login failed!");
		}
	
	

	}

}
