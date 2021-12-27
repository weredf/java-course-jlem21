package app.store;

public abstract class Vegetable extends Food{

	public Vegetable() {
		// TODO Auto-generated constructor stub
	}
	/*
	public Vegetable(double weight, Taste taste1, Taste taste2) {
		super(weight, taste1, taste2);
		// TODO Auto-generated constructor stub
	}
	*/
	public Vegetable(int weight, Taste taste) {
		super(weight, taste);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Vegetable [Weight=" + getWeight() + ", Taste=" + getTaste() + "]";
	}
	
	

}
