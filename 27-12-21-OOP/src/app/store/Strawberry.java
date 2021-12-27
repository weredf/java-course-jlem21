package app.store;

public class Strawberry extends Fruit{

	public Strawberry() {
		// TODO Auto-generated constructor stub
	}
	/*
	public Strawberry(double weight, Taste taste1, Taste taste2) {
		super(weight, taste1, taste2);
		// TODO Auto-generated constructor stub
	}
	*/
	public Strawberry(int weight, Taste taste) {
		super(weight, taste);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Strawberry [Weight=" + getWeight() + ", Taste=" + getTaste() + "]";
	}

}
