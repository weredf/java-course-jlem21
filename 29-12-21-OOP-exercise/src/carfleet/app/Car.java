package carfleet.app;

public abstract class Car {
	
	private int number;
	private int speed; // set to 0-110
	public static final int MIN_SPEED = 0;
	public static final int MAX_SPEED = 110;
	
	public Car() {
		super();
	}

	public Car(int number, int speed) {
		super();
		this.speed = speed;
		this.number = number;
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

	public boolean setSpeed(int speed) {
		if(speed >= MIN_SPEED && speed <= MAX_SPEED) {
			this.speed = speed;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Car [number=" + number + ", speed=" + speed + "]";
	} 
	
	

}
