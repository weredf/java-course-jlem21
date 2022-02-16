package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.dao.PersonDao;
import app.core.entities.Person;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		PersonDao personDao = ctx.getBean(PersonDao.class);
		/*
		{ // add person
		Person p1 = new Person(101, "aaa", 22);
		Person p2 = new Person(102, "bbb", 35);
		personDao.addPerson(p1);
		personDao.addPerson(p2);
		}
		*/
		/*
		{ // find person
			Person p3 = personDao.find(101);
			System.out.println(p3);
		}
		
		{ // delete person
			personDao.deleteById(101);
			System.out.println("deleted");
		}
		*/
		{
			Person p4 = new Person(102, "newName", 125);
			personDao.update(p4);
		}
	}

}
