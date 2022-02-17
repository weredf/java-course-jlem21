package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import app.core.exceptions.CouponSystemException;

@SpringBootApplication
//@EnableScheduling
public class Application {

	public static void main(String[] args) throws CouponSystemException, InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		System.out.println("==== Context will be closed in 2 seconds");
		Thread.sleep(2_000);
		
		ctx.close();
		System.out.println("Context closed");
	}
}
