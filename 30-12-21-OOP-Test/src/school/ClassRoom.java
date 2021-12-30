package school;

import java.util.Arrays;

public class ClassRoom {
	
	private String name;
	private Teacher teacher;
	public static final int MAX_STUDENTS = 15;
	private Student[] students = new Student[MAX_STUDENTS];
	
	public ClassRoom() {
		super();
	}

	public ClassRoom(String name, Teacher teacher, Student[] students) {
		super();
		this.name = name;
		this.teacher = teacher;
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "ClassRoom [name=" + name + ", teacher=" + teacher + ", students=" + Arrays.toString(students) + "]";
	}
	
	

}
