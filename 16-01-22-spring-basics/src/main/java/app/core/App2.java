package app.core;

import java.time.LocalDate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.Car;

public class App2 {

	public static void main(String[] args) {

		// create spring container instance - closable (ctx)
		// Config.class is a reference to the named class - in this case Config
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {
			
			System.out.println(ctx.getBean(Integer.class));
			System.out.println(ctx.getBean(Integer.class));
			System.out.println(ctx.getBean(Integer.class));
			System.out.println("========================");

			System.out.println(ctx.getBean("str1", String.class));
//			System.out.println(ctx.getBean("str2", String.class));
			System.out.println(ctx.getBean(LocalDate.class));
		}
		
	}

}
