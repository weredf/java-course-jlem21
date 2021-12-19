package c.animals;

public class Sparrow extends Bird implements Flyer{

	@Override
	public void speak() {
		System.out.println("speaks like a sparrow");
		
	}

	@Override
	public void fly() {
		System.out.println("fly like a sparrow");
		
	}

}
