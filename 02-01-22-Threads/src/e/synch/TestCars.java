package e.synch;

public class TestCars {

	public static void main(String[] args) {
		Car car1 = new Car(101);
		Car car2 = new Car(102);
		CarDriver avi = new CarDriver("Avi", car1, 150);
		CarDriver sara = new CarDriver("Sara", car1, 90);
		CarDriver uri = new CarDriver("Uri", car2, 110);
		CarDriver shira = new CarDriver("Shira", car2, 60);
		avi.start();
		sara.start();
		uri.start();
		shira.start();
	}

}
