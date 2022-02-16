package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import app.core.beans.Person;

@Configuration
@ComponentScan
public class App2 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App2.class);
	
		Person p1 = ctx.getBean("person", Person.class);
		Person p2 = ctx.getBean("person", Person.class);
		Person p3 = ctx.getBean("person", Person.class);
		Person p4 = ctx.getBean("kim", Person.class);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		ctx.close();
	}
	
	@Bean
	@Scope("prototype")
	public String name() {
		String[] names = {"Arik", "Eli", "Lisa", "Batel", "Anat", "Benny"};
		return names[(int)(Math.random()*names.length)];
	}
	
	@Bean
	public Person kim() {
		return new Person("Kim");
	}

}
