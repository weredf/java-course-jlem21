package e.synch;

import java.util.ArrayList;
import java.util.List;

public class Car {

	private int number;
	private int km;
	private List<String> registeredDrivers = new ArrayList<String>();

	public Car(int number) {
		super();
		this.number = number;
	}

	// synchronized modifier is used on critical sections - so that they cannot be run simultaneously
	public synchronized void drive(int distance) { // synchronized makes sure no doubles run in parallel
		Thread driver = Thread.currentThread();
		System.out.println("Driver " + driver.getName() + " started at " + km + " km, for a distance of " + distance + " km with car " + number + ".");
		km += distance;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Driver " + driver.getName() + " finished at " + km + " km, with car " + number + ".");
	}
	
	public void registerDriver() {
		Thread driver = Thread.currentThread();
		registeredDrivers.add(driver.getName());
		System.out.println("\tDriver " + driver.getName() + " registered to car " + number + ".");
	}
}
