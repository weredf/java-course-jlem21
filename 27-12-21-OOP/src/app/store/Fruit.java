package app.store;

public abstract class Fruit extends Food{

	public Fruit() {
		// TODO Auto-generated constructor stub
	}
	/*
	public Fruit(double weight, Taste taste1, Taste taste2) {
		super(weight, taste1, taste2);
		// TODO Auto-generated constructor stub
	}
	*/
	public Fruit(int weight, Taste taste) {
		super(weight, taste);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Fruit [Weight=" + getWeight() + ", Taste=" + getTaste() + "]";
	}
	
	

	
}
