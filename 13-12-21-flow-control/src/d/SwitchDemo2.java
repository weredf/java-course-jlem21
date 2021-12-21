package d;

public class SwitchDemo2 {

	public static void main(String[] args) {

		String day;
//		day = "Sunday";
//		day = "Monday";
//		day = "Tuesday";
//		day = "Wednesday";
//		day = "Thursday";
		day = "Friday";
//		day = "Saturday";
		System.out.println(day);
		
		
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
				System.out.println(day + "is not a day");
		}
	System.out.println("=== END ===");

	}

}
