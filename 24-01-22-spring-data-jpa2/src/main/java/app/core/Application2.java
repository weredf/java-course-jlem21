package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Person;
import app.core.service.PersonService;


@SpringBootApplication
public class Application2 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application2.class, args);
	
		// Best practice - work with service for business logic, repository only for DAO
		PersonService service = ctx.getBean(PersonService.class);
		Person person = new Person(0, "Fred", 32);
		
		service.addPerson(person);
	}

}
