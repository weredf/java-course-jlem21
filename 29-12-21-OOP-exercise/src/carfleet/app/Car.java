package carfleet.app;

public abstract class Car {
	
	private int number;
	private int speed;
	
	public Car() {
		super();
	}

	public Car(int number) {
		super();
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
		if(speed>=0 && speed <=110) {
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
