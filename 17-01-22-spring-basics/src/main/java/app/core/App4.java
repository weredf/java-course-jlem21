package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class App4 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("App4");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App4.class);
		
		Thread.sleep(3000);
		ctx.close();
		System.out.println("App4 END");
	}
}
