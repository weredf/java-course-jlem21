package b;


public class ClassRoom {

	private Teacher teacher;
	private Student[] students = new Student[25];
	
	public boolean addStudent(Student student) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;
				return true;
			}
		}
		return false;
	}
	
	
	public void showClassRoom() {
		System.out.println("==============================");
		System.out.println("Class Room: ");
		System.out.println("Teacher:");
		System.out.println(teacher);
		System.out.println();
		System.out.println("Students: ");
		for (Student students : students) {
			System.out.println(students);
		}
		System.out.println("==============================");
	}


	/**
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}


	/**
	 * @return the students
	 */
	public Student[] getStudents() {
		return students;
	}


	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	/**
	 * @param students the students to set
	 */
	public void setStudents(Student[] students) {
		this.students = students;
	}


	
	
}
