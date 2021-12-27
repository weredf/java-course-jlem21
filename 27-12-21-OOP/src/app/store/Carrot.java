package app.store;

public class Carrot extends Vegetable{

	public Carrot() {
		// TODO Auto-generated constructor stub
	}
	/*
	public Carrot(double weight, Taste taste1, Taste taste2) {
		super(weight, taste1, taste2);
		// TODO Auto-generated constructor stub
	}
	*/
	public Carrot(int weight, Taste taste) {
		super(weight, taste);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Carrot [Weight=" + getWeight() + ", Taste=" + getTaste() + "]";
	}

}
