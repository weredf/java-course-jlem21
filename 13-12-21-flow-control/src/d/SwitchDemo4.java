package d;

public class SwitchDemo4 {

	public static void main(String[] args) {
		int day = (int) (Math.random() * 7) + 1; // 1 -7 inclusive
		System.out.println(day);
		
		switch (day) {
		case 1:
		case 2:
		case 4:
		case 5:
			System.out.println("Go home @16:30");
			break;
		case 3:
			System.out.println("Go home @12:30");
			break;
		case 6:
		case 7:
			System.out.println("It's the weekend!");
			break;
			
			default:
				System.out.println(day + "is not a day");
		}
	System.out.println("=== END ===");

	}

}
