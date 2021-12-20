package a.animals;

import interfaces.AdvancedFlyer;
import interfaces.Flyer;
import interfaces.Navigator;

public class Test {

	public static void main(String[] args) {
		Animal[] animals = new Animal[10]; // plural for array
		animals[0] = new Cat();
		animals[1] = new Dog();
		animals[2] = new Bat();
		animals[3] = new Butterfly();
		animals[4] = new Sparrow();
		animals[5] = new Ostrich();
//		animals[6] = new Ant();
		animals[7] = new Butterfly();
		animals[8] = new Dog();
		animals[9] = new Bat();

		// for-each loop: each iteration we get a reference to the next element
		for (Animal animal : animals) {
			if (animal != null) {
				System.out.println(animal.getClass().getSimpleName());
				animal.speak();
				if (animal instanceof AdvancedFlyer) {
					AdvancedFlyer af = (AdvancedFlyer) animal;
					af.takeOff();
					af.fly();
					af.navigate();
					af.land();
				} else if (animal instanceof Navigator) {
					Navigator navigator = (Navigator) animal;
					navigator.navigate();
				} else if (animal instanceof Flyer) {
					Flyer flyer = (Flyer) animal;
					flyer.fly();
				}
			} else {
				System.out.println("----Empty");
			}
			System.out.println("==================");
		}

	}

}
