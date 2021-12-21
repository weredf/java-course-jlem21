package c;

public class Demo2SwitchArray {

	public static void main(String[] args) {
		//
		String[] modes = { "ON", "OFF", "STAND_BY", "SLEEP"}; // added mode SLEEP
		int index = (int)(Math.random()*modes.length); // use modes.length instead of hard coded 3
		System.out.println(modes[index]);
		
		switch (index) {
		case 0: 
			System.out.println("machine is on");
			break;
		case 1:
			System.out.println("machine is off");
			break;
		case 2:
			System.out.println("machine is on stand by");
			break;
		case 3:
			System.out.println("machine is asleep");
			break;
		}
		
		

	}

}
