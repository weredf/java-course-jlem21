package app.core.beans;

import org.springframework.stereotype.Component;

@Component
public class Gym {

	private RunningTrainer runningTrainer;
	private CyclingTrainer cyclingTrainer;
	private SwimmingTrainer swimmingTrainer;
	
	public Gym(RunningTrainer runningTrainer, CyclingTrainer cyclingTrainer, SwimmingTrainer swimmingTrainer) {
		super();
		this.runningTrainer = runningTrainer;
		this.cyclingTrainer = cyclingTrainer;
		this.swimmingTrainer = swimmingTrainer;
	}

	public RunningTrainer getRunningTrainer() {
		return runningTrainer;
	}

	public void setRunningTrainer(RunningTrainer runningTrainer) {
		this.runningTrainer = runningTrainer;
	}

	public CyclingTrainer getCyclingTrainer() {
		return cyclingTrainer;
	}

	public void setCyclingTrainer(CyclingTrainer cyclingTrainer) {
		this.cyclingTrainer = cyclingTrainer;
	}

	public SwimmingTrainer getSwimmingTrainer() {
		return swimmingTrainer;
	}

	public void setSwimmingTrainer(SwimmingTrainer swimmingTrainer) {
		this.swimmingTrainer = swimmingTrainer;
	}
	
	
	
}
