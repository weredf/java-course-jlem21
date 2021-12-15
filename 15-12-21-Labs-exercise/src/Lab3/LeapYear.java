package Lab3;

public class LeapYear {

	public static void main(String[] args) {
		int year = (int) (Math.random() * 2021);
		String leapYear = "not a leap year";
		if (year % 4 == 0 && year % 100 != 0) {
			leapYear = "a leap year";
		} else if (year % 400 == 0) {
			leapYear = "a leap year";
		}
		System.out.println(year);
		System.out.println("This year is " + leapYear + ".");
	}

}
