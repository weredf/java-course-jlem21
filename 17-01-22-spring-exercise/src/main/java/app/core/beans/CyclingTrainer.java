package app.core.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CyclingTrainer implements Trainer {

	@Value("${trainer.program.cycle}")
	private String trainingProgram;
	
	
	public CyclingTrainer() {
		super();
	}

	public String getTrainingProgram() {
		return trainingProgram;
	}

}
