package app.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Airplane implements Vehicle {

	private int c;
	
	private int number = ++c;
	@Autowired
	private Engine airplaneEngine; // qualify by name
	
	public void start() {
		this.airplaneEngine.switchOn();;
	}

	public void goTo(String destination) {
		System.out.println("going to " + destination);
	}

	public void stop() {
		this.airplaneEngine.switchOff();;
	}

}
