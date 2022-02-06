package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.Airplane;
import app.core.beans.Boat;
import app.core.beans.FamilyCar;
import app.core.beans.Vehicle;

public class App2 {

	public static void main(String[] args) {

		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {
			FamilyCar car = ctx.getBean(FamilyCar.class);
			System.out.println("max speed: " + car.getMaxSpeed());
		}
	}

}
