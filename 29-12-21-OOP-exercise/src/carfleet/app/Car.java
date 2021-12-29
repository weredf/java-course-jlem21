package carfleet.app;

public abstract class Car {
	
	private int number;
	private int speed;
	
	public Car() {
		super();
	}

	public Car(int number, int speed) {
		super();
		this.number = number;
		this.speed = speed;
	}

	public int getNumber() {
		return number;
	}

	public int getSpeed() {
		return speed;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	} 
	
	

}
