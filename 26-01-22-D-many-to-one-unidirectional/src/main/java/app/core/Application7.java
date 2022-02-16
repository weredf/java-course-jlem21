package app.core;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Student;
import app.core.entities.University;
import app.core.repositories.StudentRepo;
import app.core.repositories.UniversityRepo;

@SpringBootApplication
public class Application7 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application7.class, args);
		
		UniversityRepo universityRepo = ctx.getBean(UniversityRepo.class);
		StudentRepo studentRepo = ctx.getBean(StudentRepo.class);
		
		Optional<Student> opt = studentRepo.findById(1);
		if(opt.isPresent()) {
			Student student = opt.get();
			University uni = student.getUniversity();
			System.out.println(student);
			System.out.println(uni);
		}
	}

}
