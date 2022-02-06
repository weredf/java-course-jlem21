package app.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Primary // this is now the primary vehicle, not RaceCar
public class FamilyCar implements Vehicle {

	private int c; // this is just for generating new car numbers
	
	private int number = ++c;
	
	// inject value from properties file - always text or numbers
	@Value("${car.max.speed:-1}") // 80: fallback, in case reading properties fails
	private int maxSpeed;
	
	// this is a dependency - helper class
	// it need to be injected by the container
	@Autowired
	@Qualifier("carEngine") // qualify by comment
	private CarEngine engine;
	
	@Override
	public void start() {
		this.engine.switchOn();
	}

	@Override
	public void goTo(String destination) {
		System.out.println("going to " + destination);
	}

	@Override
	public void stop() {
		this.engine.switchOff();
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

}
