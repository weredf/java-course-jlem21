package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(Application.class, args);
		
		BankSpring b1 = ctx.getBean("bankSpring", BankSpring.class); // autowired CTOR
		BankSpring b2 = ctx.getBean("bankSpring", BankSpring.class); // autowired CTOR
		
		BankSpring b3 = ctx.getBean("otherBank", BankSpring.class); // uses empty CTOR, still same bank as 1 & 2

		// all print same bank defined in application properties
		System.out.println(b1);
		System.out.println(b2); // same as b2
		
		// bean definition, other bank
		System.out.println(b3);

		
		BankSpring b4 = new BankSpring();
		BankSpring b5 = new BankSpring();
		
		// not managed by spring - different banks
		System.out.println(b4);
		System.out.println(b5);
	}
	
	@Bean // bean definition, default scope is singleton!
	public BankSpring otherBank() {
		BankSpring b = new BankSpring(); // single instance of otherBank
		b.setName("the other bank");
		return b;
	}

}
