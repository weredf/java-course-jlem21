package school;

import java.util.Arrays;

//import school.Grade.Profession;

public class Student extends Person{

	public static final int MAX_GRADES = 6;
	private Grade[] grades = new Grade[MAX_GRADES];

	public Student() {
		super();
	}

	public Student(String name, int age, Grade[] grades) {
		super(name, age);
		this.grades = grades;
	}
	

	public Grade[] getGrades() {
		return grades;
	}

	public void setGrades(Grade[] grades) {
//		for (int i = 0; i < grades.length; i++) {
//			grades[i]= new Grade(Profession.values()[i];
//		}
		this.grades = grades;
	}

	@Override
	public String toString() {
		return "Student [name=" + getName() + ", age=" + getAge()
				+ ", grades=" + Arrays.toString(grades) + "]";
	}
	
	
}
