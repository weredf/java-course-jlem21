package school;

public class SchoolStatistics {

	private static int classroomNumber = 01;
	private static int teacherNumber = 1;
	private static int studentNumber = 1;
	private static int p1 = 0;
	private static int p2 = 1;
	private static int p3 = 2;
	private static int p4 = 3;
	private static int p5 = 4;
//	private static int p6 = 5;
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
	private static int cM = 0;
	private static int cP = 0;
	private static int cS = 0;
	private static int cL = 0;

	public static void main(String[] args) {

		School school = getRandomSchool();
		showSchool(school);
		showSchoolAverageGrade(school);
		updateSchoolProfessionAverageGrade(school);
		AverageGradeYoungStudents(school);
		AverageGradeOldStudents(school);
		AverageAgeStudents(school);
		checkMathPhysicsTeachers(school);
		checkSportLitTeachers(school);
		checkStudentSportsTeam(school);
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
				System.out.println("\t" + student.getGrades()[i].getProfession() + ", score: "
						+ student.getGrades()[i].getScore());
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

	// redundancy issues solved
	private static Student getRandomStudent() {
		Student student = new Student();
		student.setName("S" + studentNumber++);
		student.setAge(getRandomAge());
//		int numberOfGrades = (int) (Math.random() * Student.MAX_GRADES + 1);
		for (int i = 0; i < student.getGrades().length; i++) { // length was numberOfGrades
			student.getGrades()[i] = getRandomGrade();
			student.getGrades()[i].setProfession(Profession.values()[i]);
			/*
			 * attempt to take out redundancies for (int j = 0; j < numberOfGrades; j++) {
			 * if (student.getGrades()[j] != null && student.getGrades()[i].getProfession()
			 * == student.getGrades()[j].getProfession()) { int x =
			 * student.getGrades()[i].getProfession().ordinal(); if (x<5) {
			 * student.getGrades()[i].setProfession(Profession.values()[x+1]); } else {
			 * student.getGrades()[i].setProfession(Profession.values()[x-1]); } } }
			 */
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

	// student average grade
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
		System.out.println(Profession.values()[0] + " average score: " + sumP1 / cP1);
		System.out.println(Profession.values()[1] + " average score: " + sumP2 / cP2);
		System.out.println(Profession.values()[2] + " average score: " + sumP3 / cP3);
		System.out.println(Profession.values()[3] + " average score: " + sumP4 / cP4);
		System.out.println(Profession.values()[4] + " average score: " + sumP5 / cP5);
		System.out.println(Profession.values()[5] + " average score: " + sumP6 / cP6);
		System.out.println("=============================");
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
				if (student.getGrades()[i].getProfession() == Profession.values()[p1]) {
					sumP1 += student.getGrades()[i].getScore();
					cP1++;
				} else if (student.getGrades()[i].getProfession() == Profession.values()[p2]) {
					sumP2 += student.getGrades()[i].getScore();
					cP2++;
				} else if (student.getGrades()[i].getProfession() == Profession.values()[p3]) {
					sumP3 += student.getGrades()[i].getScore();
					cP3++;
				} else if (student.getGrades()[i].getProfession() == Profession.values()[p4]) {
					sumP4 += student.getGrades()[i].getScore();
					cP4++;
				} else if (student.getGrades()[i].getProfession() == Profession.values()[p5]) {
					sumP5 += student.getGrades()[i].getScore();
					cP5++;
				} else {
					sumP6 += student.getGrades()[i].getScore();
					cP6++;
				}
			}
		}
	}

	// bonus 1 - students age 20-30, average grade

	private static void AverageGradeYoungStudents(School school) {
		int sum = 0;
		int c = 0;
		for (int i = 0; i < school.getClassrooms().length; i++) {
			if (school.getClassrooms()[i] != null) {
				for (int j = 0; j < school.getClassrooms()[i].getStudents().length; j++) {
					if (school.getClassrooms()[i].getStudents()[j] != null
							&& school.getClassrooms()[i].getStudents()[j].getAge() <= 30) {
						for (int k = 0; k < school.getClassrooms()[i].getStudents()[j].getGrades().length; k++) {
							if (school.getClassrooms()[i].getStudents()[j].getGrades()[k] != null) {
								sum += school.getClassrooms()[i].getStudents()[j].getGrades()[k].getScore();
								c++;
							}
						}
					}
				}
			}
		}
		System.out.println("Average grade 20-30 year old students is: " + sum / c);
		System.out.println("=============================");
	}

	// bonus 2 - students age 31 and up, average grade

	private static void AverageGradeOldStudents(School school) {
		int sum = 0;
		int c = 0;
		for (int i = 0; i < school.getClassrooms().length; i++) {
			if (school.getClassrooms()[i] != null) {
				for (int j = 0; j < school.getClassrooms()[i].getStudents().length; j++) {
					if (school.getClassrooms()[i].getStudents()[j] != null
							&& school.getClassrooms()[i].getStudents()[j].getAge() > 30) {
						for (int k = 0; k < school.getClassrooms()[i].getStudents()[j].getGrades().length; k++) {
							if (school.getClassrooms()[i].getStudents()[j].getGrades()[k] != null) {
								sum += school.getClassrooms()[i].getStudents()[j].getGrades()[k].getScore();
								c++;
							}
						}
					}
				}
			}
		}
		System.out.println("Average grade 31+ year old students is: " + sum / c);
		System.out.println("=============================");
	}
	// bonus 3 - average age of all students

	private static void AverageAgeStudents(School school) {
		int sum = 0;
		int c = 0;
		for (int i = 0; i < school.getClassrooms().length; i++) {
			if (school.getClassrooms()[i] != null) {
				for (int j = 0; j < school.getClassrooms()[i].getStudents().length; j++) {
					if (school.getClassrooms()[i].getStudents()[j] != null) {
						sum += school.getClassrooms()[i].getStudents()[j].getAge();
						c++;
					}
				}
			}
		}
		System.out.println("Average age of students is: " + sum / c);
		System.out.println("=============================");
	}

	// bonus 4 - number of teachers that teach math, physics

	private static void checkMathPhysicsTeachers(School school) {
		for (int i = 0; i < school.getClassrooms().length; i++) {
			if (school.getClassrooms()[i].getTeacher().getProfession() == Profession.Math) {
				cM++;
			} else if (school.getClassrooms()[i].getTeacher().getProfession() == Profession.Physics) {
				cP++;
			}
		}
		System.out.println("Number of teachers that teach Math: " + cM);
		System.out.println("Number of teachers that teach Physics: " + cP);
	}

	// bonus 5 - number of teachers that teach sports, literature

	private static void checkSportLitTeachers(School school) {
		for (int i = 0; i < school.getClassrooms().length; i++) {
			if (school.getClassrooms()[i].getTeacher().getProfession() == Profession.Sports) {
				cS++;
			} else if (school.getClassrooms()[i].getTeacher().getProfession() == Profession.Literature) {
				cL++;
			}
		}
		System.out.println("Number of teachers that teach Sports: " + cS);
		System.out.println("Number of teachers that teach Literature: " + cL);
		System.out.println("=============================");

	}

	// bonus 6 - sports team consisting of students that have 90 and up in sports

	private static void checkStudentSportsTeam(School school) {
		System.out.println("School Student Sports Team: ");
		for (int i = 0; i < school.getClassrooms().length; i++) {
			for (int j = 0; j < school.getClassrooms()[i].getStudents().length; j++) {
				if (school.getClassrooms()[i].getStudents()[j] != null) {
					for (int k = 0; k < school.getClassrooms()[i].getStudents()[j].getGrades().length; k++) {
						if (school.getClassrooms()[i].getStudents()[j].getGrades()[k]
								.getProfession() == Profession.Sports) {
							if (school.getClassrooms()[i].getStudents()[j].getGrades()[k].getScore() >= 90) {
								System.out.println("\t" + school.getClassrooms()[i].getStudents()[j].getName());
							}
						}
					}
				}
			}
		}
		System.out.println("=============================");
	}
}
