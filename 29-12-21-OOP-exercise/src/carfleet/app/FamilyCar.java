package carfleet.app;

public class FamilyCar extends Car{

	public FamilyCar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FamilyCar(int number) {
		super(number);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FamilyCar [number=" + getNumber() + ", speed=" + getSpeed() + "]";
	}
	
	

}
