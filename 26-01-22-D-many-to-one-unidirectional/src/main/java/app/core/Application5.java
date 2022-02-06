package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Student;
import app.core.entities.University;
import app.core.repositories.StudentRepo;
import app.core.repositories.UniversityRepo;

@SpringBootApplication
public class Application5 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application5.class, args);
		UniversityRepo universityRepo = ctx.getBean(UniversityRepo.class);
		StudentRepo studentRepo = ctx.getBean(StudentRepo.class);
		
		University uniYale = new University(0, "Yale", "USA");
		University uniIvrit = new University(0, "Ivrit", "Israel");
		
		Student s1 = new Student(0, "Micky", uniIvrit);
//		Student s2 = new Student(0, "Maya", uniIvrit);
//		Student s3 = new Student(0, "Mira", uniIvrit);

		Student s4 = new Student(0, "John", uniYale);
//		Student s5 = new Student(0, "Robby", uniYale);
		
		/*
		Student[] arr1 = {s1, s2, s3};
		Student[] arr2 = {s4, s5};
		
		for(Student student: arr1) {
			student = studentRepo.save(student);
			uniIvrit = student.getUniversity();
		}
		*/
		
		studentRepo.save(s1);
		studentRepo.save(s4);
		System.out.println();
		
		
	}

}
