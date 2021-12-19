package c.animals;

public class Butterfly extends Insect implements Flyer{

	@Override
	public void speak() {
		System.out.println("speaks like an butterfly");
		
	}

	@Override
	public void fly() {
		System.out.println("fly like a butterfly");
		
	}

}
