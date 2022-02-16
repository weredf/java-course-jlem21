package app.core.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimmingTrainer implements Trainer {

	@Value("${trainer.program.swim}")
	private String trainingProgram;
	
	public SwimmingTrainer() {
		super();
	}

	public String getTrainingProgram() {
		return trainingProgram;
	}

}
