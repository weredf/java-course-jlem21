package carfleet.app;

public class Highway {
	
	private Name name;
	Car[] cars = new Car[100];
	
	public enum Name {
		HIGHWAY1, HIGHWAY2, HIGHWAY3, HIGHWAY4, HIGHWAY5
	}
	
	
	public Highway() {
		super();
	}


	public Highway(Name name, Car[] cars) {
		super();
		this.name = name;
		this.cars = cars;
	}


	public Name getName() {
		return name;
	}


	public Car[] getCars() {
		return cars;
	}


	public void setName(Name name) {
		this.name = name;
	}


	public void setCars(Car[] cars) {
		this.cars = cars;
	}


}
