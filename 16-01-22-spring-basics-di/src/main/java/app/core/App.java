package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.Airplane;
import app.core.beans.Boat;
import app.core.beans.Vehicle;

public class App {

	public static void main(String[] args) {

		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {
			// ask for a vehicle
//			Vehicle v1 = ctx.getBean("raceCar", Vehicle.class);
			Vehicle v1 = ctx.getBean(Vehicle.class);
			v1.start();
			v1.goTo("Eilat");
			v1.stop();
			
//			FamilyCar car = ctx.getBean(FamilyCar.class);
			
			Boat b1 = ctx.getBean(Boat.class);
			b1.start();
			b1.goTo("Cyprus");
			b1.stop();
			
			Airplane a1 = ctx.getBean(Airplane.class);
			a1.start();
			a1.goTo("Amsterdam");
			a1.stop();
			
			System.out.println("===================");
			
			Vehicle[] vehicles = new Vehicle[5];
			vehicles[0] = v1;
			vehicles[1] = b1;
			vehicles[2] = a1;
			
			for (int i =0; i<5; i++) {
				if(vehicles[i]!=null) {
					vehicles[i].start();
					vehicles[i].goTo("destination");
					vehicles[i].stop();
				}
			}
			
		}
	}

}
