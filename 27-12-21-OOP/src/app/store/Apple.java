package app.store;

public class Apple extends Fruit{

	public Apple() {
		// TODO Auto-generated constructor stub
	}
	/*
	public Apple(double weight, Taste taste1, Taste taste2) {
		super(weight, taste1, taste2);
		// TODO Auto-generated constructor stub
	}
	*/
	public Apple(int weight, Taste taste) {
		super(weight, taste);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Apple [Weight=" + getWeight() + ", Taste=" + getTaste() + "]";
	}

	
}
