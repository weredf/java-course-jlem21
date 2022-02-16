package app.core;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import app.core.entities.Student;
import app.core.entities.Student.Gender;
import app.core.service.StudentService;

@SpringBootApplication
public class Application3 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application3.class, args);

		StudentService service = ctx.getBean(StudentService.class);
		
		String[] names = {"Dan", "Betty", "Gal", "Linda", "Dor", "Erez"};
		/*
		for(int i = 0; i <10; i++) {
			Student s1 = new Student(0, null, 0, "abc@mail.com", null, LocalDate.of(2020, 1, 1), true);
			s1.setName(names[(int) (Math.random() * names.length)]);
			s1.setAge((int)(Math.random() * 100));
			s1.setGender(Math.random() < 0.5 ? Gender.M : Gender.F);
			s1.setActive(Math.random() < 0.5 ? true : false);
			service.addStudent(s1);
		}
		*/
		/*
		List<Student> femaleStudents = service.getFemaleStudents();
		for(Student student : femaleStudents) {
			System.out.println(student);
		}

		System.out.println("====================");
//		List<Student> maleStudents = service.getMaleStudents(Sort.by("age")); // default is ascending
//		List<Student> maleStudents = service.getMaleStudents(Sort.by(Direction.ASC, "age")); // ascending
		List<Student> maleStudents = service.getMaleStudents(Sort.by(Direction.DESC, "age")); // descending
		for(Student student : maleStudents) {
			System.out.println(student);
		}
		
		System.out.println("====================");
		List<Student> olderStudents = service.getStudentsOlderThan(65);
		for(Student student: olderStudents) {
			System.out.println(student);
		}
		*/
		
//		System.out.println("====================");
		List<Student> nameGal = service.getStudentsByName("Gal");
		for(Student student: nameGal) {
			System.out.println(student);
		}
	}
}
