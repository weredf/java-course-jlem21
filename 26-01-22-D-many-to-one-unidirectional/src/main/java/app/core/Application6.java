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
public class Application6 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application6.class, args);
		
		UniversityRepo universityRepo = ctx.getBean(UniversityRepo.class);
		StudentRepo studentRepo = ctx.getBean(StudentRepo.class);
		
		Optional<University> opt = universityRepo.findById(1);
		if(opt.isPresent()) {
			University uniIvrit = opt.get();
			Student s2 = new Student(0, "Maya", uniIvrit);
			Student s3 = new Student(0, "Mira", uniIvrit);
			Student[] arr1 = {s2, s3};
			for(Student student: arr1) {
				studentRepo.save(student);
			}	
		} else {
			System.out.println("University not found");
		}
		
		
//		Student s5 = new Student(0, "Robby", uniYale);
		
		/*
		
			uniIvrit = student.getUniversity();
		}
		*/
		
	}

}
