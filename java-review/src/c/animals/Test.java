package c.animals;

public class Test {

	public static void main(String[] args) {
		Animal[] animals = new Animal[7];
		animals[0] = new Cat();
		animals[1] = new Dog();
		animals[2] = new Bat();
		animals[3] = new Butterfly();
		animals[4] = new Sparrow();
		animals[5] = new Ostrich();
		animals[6] = new Ant();
		
		for (int i = 0; i < animals.length; i++) {
			Animal animal = animals[i];
			if(animal != null) {
				animal.speak();		// abstract inheritance	
				if(animal instanceof Flyer) {
					Flyer flyer = (Flyer) animal;
					flyer.fly();
				}
			}
			System.out.println("==================");
		}

	}

}
