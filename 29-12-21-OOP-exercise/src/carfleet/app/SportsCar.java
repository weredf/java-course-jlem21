package carfleet.app;

public class SportsCar extends Car{

	public SportsCar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SportsCar(int number) {
		super(number);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SportsCar [number=" + getNumber() + ", speed()=" + getSpeed() + "]";
	}
	
	

}
