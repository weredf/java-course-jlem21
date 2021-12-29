package carfleet.app;

import java.util.Arrays;

public class Highway {
	
	private String name;
	private Car[] cars = new Car[100];
	/*
	public enum Name {
		HIGHWAY1, HIGHWAY2, HIGHWAY3, HIGHWAY4, HIGHWAY5
	}
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


	@Override
	public String toString() {
		return "Highway [name=" + name + ", cars=" + Arrays.toString(cars) + "]";
	}
	
	
}
