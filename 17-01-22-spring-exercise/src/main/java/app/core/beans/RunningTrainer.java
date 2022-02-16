package app.core.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RunningTrainer implements Trainer {

	@Value("${trainer.program.run}")
	private String trainingProgram;
	
	public RunningTrainer() {
		super();
	}

	public String getTrainingProgram() {
		return trainingProgram;
	}

}
