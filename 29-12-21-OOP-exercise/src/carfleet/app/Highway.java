package carfleet.app;

import java.util.Arrays;

public class Highway {

	private String name;
	public static final int MAX = 100;
	private Car[] cars = new Car[MAX];
	/*
	 * public enum Name { HIGHWAY1, HIGHWAY2, HIGHWAY3, HIGHWAY4, HIGHWAY5 }
	 */

	public Highway() {
		super();
	}

	public Highway(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Car[] getCars() {
		return cars;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCars(Car[] cars) {
		this.cars = cars;
	}

	public void addCar(Car car) {
		for (int i = 0; i < cars.length; i++) {
			if (this.cars[i] == null) {
				this.cars[i] = car;
				return;
			}
		}
	}

	public int getNumberOfCars() {
		int c = 0;
		for (Car car : cars) {
			if (car != null) {
				c++;
			}
		}
		return c;
	}

	@Override
	public String toString() {
		return "Highway [name=" + name + ", cars=" + Arrays.toString(cars) + "]";
	}

}
