package app.store;

public abstract class Food {
	
	private int weight;
	private Taste taste;
	public enum Taste {
		SWEET, SOUR, BITTER, SALTY,	UMAMI
	}
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Food(int weight, Taste taste) {
		super();
		this.weight = weight;
		this.taste = taste;
	}
	/*
	public Food(double weight, Taste taste1, Taste taste2) {
		super();
		this.weight = weight;
	}
	*/
	public double getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}


	/**
	 * @return the taste
	 */
	public Taste getTaste() {
		return taste;
	}


	/**
	 * @param taste the taste to set
	 */
	public void setTaste(Taste taste) {
		this.taste = taste;
	}


	@Override
	public String toString() {
		return "Food [weight=" + weight + ", taste=" + taste + "]";
	}




}
