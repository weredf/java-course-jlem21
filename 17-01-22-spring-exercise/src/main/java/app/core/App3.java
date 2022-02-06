package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import app.core.beans.Trainer;

@Configuration
@ComponentScan
@PropertySource("application.properties")
public class App3 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App3.class);

		String[] arr = ctx.getBeanDefinitionNames();
		for (String beanName : arr) {
			System.out.println(beanName);
		}
		
		System.out.println("=============");

		Trainer t = ctx.getBean("runningTrainer", Trainer.class);
		System.out.println(t);
		
		ctx.close();

	}
}
