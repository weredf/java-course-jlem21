package lab1;

public class TestMovie {

	public static void main(String[] args) {
		int time = (int) (Math.random() * 251) + 100;
		System.out.println(time + " minutes");
		System.out.println(((int)time/60) + " hours and " + (time%60) + " minutes");		
	}

}
