package app.store;

public class Tomato extends Vegetable{

	public Tomato() {
		// TODO Auto-generated constructor stub
	}
	/*
	public Tomato(double weight, Taste taste1, Taste taste2) {
		super(weight, taste1, taste2);
		// TODO Auto-generated constructor stub
	}
	*/
	public Tomato(int weight, Taste taste) {
		super(weight, taste);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tomato [Weight=" + getWeight() + ", Taste=" + getTaste() + "]";
	}

}
