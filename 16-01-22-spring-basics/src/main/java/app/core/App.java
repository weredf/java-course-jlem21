package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.Car;

public class App {

	public static void main(String[] args) {

		// create spring container instance - closable
		// Config.class is a reference to the named class - in this case Config
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {
			
			// ask for beans
			Car car1 = ctx.getBean("numberedCar", Car.class);
			Car car2 = ctx.getBean("numberedCar", Car.class);
			// set the state
//			car1.setNumber(111);
//			car2.setNumber(222);
			// print
			System.out.println(car1);
			System.out.println(car2);
		}
		
	}

}
