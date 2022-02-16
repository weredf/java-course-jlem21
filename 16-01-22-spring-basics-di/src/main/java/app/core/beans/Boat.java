package app.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Boat implements Vehicle {

	private int c;
	
	private int number = ++c;
	@Autowired
//	private BoatEngine engine; // not good if different types of engines
	private Engine boatEngine;
	
	public void start() {
		this.boatEngine.switchOn();
	}

	public void goTo(String destination) {
		System.out.println("going to " + destination);
	}

	public void stop() {
		this.boatEngine.switchOff();
	}

}
