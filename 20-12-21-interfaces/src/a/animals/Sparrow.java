package a.animals;

import interfaces.Flyer;

public class Sparrow extends Bird implements Flyer{

	@Override
	public void speak() {
		System.out.println("speak like a sparrow");
		
	}

	@Override
	public void fly() {
		System.out.println("fly like a sparrow");
		
	}

}
