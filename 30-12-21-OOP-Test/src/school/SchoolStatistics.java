package school;

public class SchoolStatistics {

	private static int classroomNumber = 01;
	private static int teacherNumber = 1;
	private static int studentNumber = 1;
	private static int p1 = 0;
	private static int p2 = 0;
	private static int p3 = 0;
	private static int p4 = 0;
	private static int p5 = 0;
	private static int p6 = 0;
	private static int sumP1 = 0;
	private static int sumP2 = 0;
	private static int sumP3 = 0;
	private static int sumP4 = 0;
	private static int sumP5 = 0;
	private static int sumP6 = 0;
	private static int cP1 = 0;
	private static int cP2 = 0;
	private static int cP3 = 0;
	private static int cP4 = 0;
	private static int cP5 = 0;
	private static int cP6 = 0;

	public static void main(String[] args) {

		School school = getRandomSchool();
		showSchool(school);
		showSchoolAverageGrade(school);
		updateSchoolProfessionAverageGrade(school);
		
	}

	// print school, all 5 classes with their teacher, with their attributes
	private static void showSchool(School school) {
		for (int i = 0; i < school.getClassrooms().length; i++) {
			System.out.println("Class " + school.getClassrooms()[i].getName() + ": ");
			System.out.println("Teacher " + school.getClassrooms()[i].getTeacher().getName() + ", profession: "
					+ school.getClassrooms()[i].getTeacher().getProfession() + ", age: "
					+ school.getClassrooms()[i].getTeacher().getAge());
			showClass(school.getClassrooms()[i]);
			System.out.println("=============================");
		}
	}

	// print students in each class
	private static void showClass(ClassRoom classRoom) {
		for (int i = 0; i < classRoom.getStudents().length; i++) {
			if (classRoom.getStudents()[i] != null) {
				System.out.println("Student " + classRoom.getStudents()[i].getName() + ", age: "
						+ classRoom.getStudents()[i].getAge());
				showGrades(classRoom.getStudents()[i]);
				System.out.println("-----------------------------");
			}
		}
	}

	// print grades (profession, score)
	private static void showGrades(Student student) {
		for (int i = 0; i < student.getGrades().length; i++) {
			if (student.getGrades()[i] != null) {
				System.out.println(
						student.getGrades()[i].getProfession() + ", score: " + student.getGrades()[i].getScore());
			}
		}
	}

	
	// get random objects and attributes
	public static School getRandomSchool() {
		School school = new School();
		for (int i = 0; i < school.getClassrooms().length; i++) {
			school.getClassrooms()[i] = getRandomClassRoom();
		}
		return school;
	}

	private static ClassRoom getRandomClassRoom() {
		ClassRoom classroom = new ClassRoom();
		classroom.setName("C-" + classroomNumber++);
		classroom.setTeacher(getRandomTeacher());
		int numberOfStudents = (int) (Math.random() * ClassRoom.MAX_STUDENTS + 1);
		for (int i = 0; i < numberOfStudents; i++) {
			classroom.getStudents()[i] = getRandomStudent();
		}
		return classroom;
	}

	private static Teacher getRandomTeacher() {
		Teacher teacher = new Teacher();
		teacher.setName("T" + teacherNumber++);
		teacher.setAge(getRandomAge());
		teacher.setProfession(getRandomProfession());
		return teacher;
	}

	private static Profession getRandomProfession() {
		Profession profession = Profession.values()[(int) (Math.random() * Profession.values().length)];
		return profession;
	}

	private static Student getRandomStudent() {
		Student student = new Student();
		student.setName("S" + studentNumber++);
		student.setAge(getRandomAge());
		int numberOfGrades = (int) (Math.random() * Student.MAX_GRADES + 1);
		for (int i = 0; i < numberOfGrades; i++) {
			student.getGrades()[i] = getRandomGrade(); // sometimes duplicate subject, to solve
		}
		return student;
	}

	private static int getRandomAge() {
		int age = (int) (Math.random() * (Person.MAX_AGE - Person.MIN_AGE) + Person.MIN_AGE);
		return age;
	}

	private static Grade getRandomGrade() {
		Grade grade = new Grade();
		grade.setProfession(getRandomProfession());
		grade.setScore(getRandomScore());
		return grade;
	}

	private static int getRandomScore() {
		int score = (int) (Math.random() * (Grade.MAX_SCORE - Grade.MIN_SCORE) + Grade.MIN_SCORE);
		return score;
	}

	
	// school average grade
	private static void showSchoolAverageGrade(School school) {
		int sum = 0;
		int c = 0;
		for (int i = 0; i < school.getClassrooms().length; i++) {
			if (school.getClassrooms()[i] != null) {
				int classAverage = getClassAverageGrade(school.getClassrooms()[i]);
				sum += classAverage;
				c++;
			}
		}
		System.out.println("Average grade in this school is: " + sum / c);
		System.out.println("=============================");

	}

	// class average grade
	private static int getClassAverageGrade(ClassRoom classRoom) {
		int sum = 0;
		int c = 0;
		for (int i = 0; i < classRoom.getStudents().length; i++) {
			if (classRoom.getStudents()[i] != null) {
				int studentAverage = getStudentAverageScore(classRoom.getStudents()[i]);
				sum += studentAverage;
				c++;
			}
		}
		System.out.println("Class " + classRoom.getName() + ", average grade is: " + sum / c);
		return sum / c;

	}

	//student average grade
	private static int getStudentAverageScore(Student student) {
		int sum = 0;
		int c = 0;
		for (int i = 0; i < student.getGrades().length; i++) {
			if (student.getGrades()[i] != null) {
				sum += student.getGrades()[i].getScore();
				c++;
			}
		}
		if (c > 0) {
			return sum / c;
		}
		return 0;
	}
	
	
	// update profession average for school
	private static void updateSchoolProfessionAverageGrade(School school) {
		
		for (int i = 0; i < school.getClassrooms().length; i++) {
			if (school.getClassrooms()[i] != null) {
				updateClassProfessionAverageGrade(school.getClassrooms()[i]);
			}
		}
		System.out.println(Profession.values()[0] + " average score: " + sumP1/cP1);
		System.out.println(Profession.values()[1] + " average score: " + sumP2/cP2);
		System.out.println(Profession.values()[2] + " average score: " + sumP3/cP3);
		System.out.println(Profession.values()[3] + " average score: " + sumP4/cP4);
		System.out.println(Profession.values()[4] + " average score: " + sumP5/cP5);
		System.out.println(Profession.values()[5] + " average score: " + sumP6/cP6);

	}
	
	// update profession average per class
	private static void updateClassProfessionAverageGrade(ClassRoom classRoom) {
		for (int i = 0; i < classRoom.getStudents().length; i++) {
			if (classRoom.getStudents()[i] != null) {
				updateStudentProfessionAverageScore(classRoom.getStudents()[i]);
			}
		}

	}
	
	// update profession average per student
	private static void updateStudentProfessionAverageScore(Student student) {
		for (int i = 0; i < student.getGrades().length; i++) {
			if (student.getGrades()[i] != null) {
				if (student.getGrades()[i].getProfession() == Profession.values()[0]) {
					sumP1 += student.getGrades()[i].getScore();
					cP1++;
				} else if (student.getGrades()[i].getProfession() == Profession.values()[1]){
					sumP2 += student.getGrades()[i].getScore();
					cP2++;
				}else if (student.getGrades()[i].getProfession() == Profession.values()[2]) {
					sumP3 += student.getGrades()[i].getScore();
					cP3++;
				}else if (student.getGrades()[i].getProfession() == Profession.values()[3]) {
					sumP4 += student.getGrades()[i].getScore();
					cP4++;
				}else if (student.getGrades()[i].getProfession() == Profession.values()[4]) {
					sumP5 += student.getGrades()[i].getScore();
					cP5++;
				}else {
					sumP6 += student.getGrades()[i].getScore();
					cP6++;
				}
			}
		}
	}
	
}
