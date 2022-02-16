package app.core;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.University;
import app.core.repositories.StudentRepo;
import app.core.repositories.UniversityRepo;

@SpringBootApplication
public class Application2 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application2.class, args);
		
		UniversityRepo universityRepo = ctx.getBean(UniversityRepo.class);
		StudentRepo studentRepo = ctx.getBean(StudentRepo.class);
		
		int uniId = 1;
		
		Optional<University> opt = universityRepo.findById(uniId);
		if(opt.isPresent()) {
			University u = opt.get();
			System.out.println(u);
			System.out.println(studentRepo.findByUniversityId(uniId));
		} else {
			System.out.println("Not found");
		}
		
		
		
	}

}
