package app.core;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Student;
import app.core.repository.StudentRepository;

@SpringBootApplication
public class Application4 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application4.class, args);

		StudentRepository repository = ctx.getBean(StudentRepository.class);
		
		List<Student> actives = repository.findByActiveIsTrue();
		for(Student student: actives) {
			System.out.println(student);
		}

		List<Student> inactives = repository.findByActiveIsFalse();
		for(Student student: inactives) {
			System.out.println(student);
		}
	}
}
