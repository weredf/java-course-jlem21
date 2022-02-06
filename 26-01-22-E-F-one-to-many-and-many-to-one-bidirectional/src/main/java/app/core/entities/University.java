package app.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "students")
@Entity
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String country;
	
	@OneToMany(mappedBy = "university", cascade = CascadeType.ALL) // lazy default, add method to repo in order to get students list for university
	private List<Student> students;
	
	public void addStudent(Student student) {
		if(students == null) {
			this.students = new ArrayList<>();
		}
		student.setUniversity(this);
		students.add(student);
	}
	
	public void setStudents(List<Student> list) {
		for (Student student: list) {
			student.setUniversity(this);
		}
		this.students = list;
	}
}
