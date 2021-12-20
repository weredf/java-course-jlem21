package d.enums;

import d.enums.Car.Type;

public class TestCar {

	public static void main(String[] args) {

		Car car1 = new Car(1, 30, Color.RED, Type.SPORT);
		System.out.println(car1);

	}

}
