package d;

import java.util.Scanner;

public class SwitchDemo3Input {

	public static void main(String[] args) {

		// input from user ========================================
		Scanner sc = new Scanner(System.in); // input from keyboard
		System.out.print("enter day: ");
		String day = sc.nextLine();
		sc.close(); // close the scanner
		// ========================================================
		System.out.println("You entered: " + day); // print the user input
		
		switch (day) {
		case "Sunday":
		case "Monday":
		case "Wednesday":
		case "Thursday":
			System.out.println("Go home @16:30");
			break;
		case "Tuesday":
			System.out.println("Go home @12:30");
			break;
		case "Friday":
		case "Saturday":
			System.out.println("It's the weekend!");
			break;
			
			default:
				System.out.println(day + " is not a day");
		}
	System.out.println("=== END ===");

	}

}
