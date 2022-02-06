package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import app.core.beans.CyclingTrainer;
import app.core.beans.SwimmingTrainer;
import app.core.beans.Trainer;

@Configuration
@ComponentScan
@PropertySource("application.properties")
public class App {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);

		Trainer t;
		t = ctx.getBean(CyclingTrainer.class);
		System.out.println(t.getTrainingProgram());
		
		t = ctx.getBean("runningTrainer", Trainer.class);
		System.out.println(t.getTrainingProgram());
		
		t = ctx.getBean(SwimmingTrainer.class);
		System.out.println(t.getTrainingProgram());
		
		ctx.close();

	}
}
