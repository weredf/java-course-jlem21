package b;

import b.Person.Name;
import b.Teacher.Degree;

public class School {

	public static void main(String[] args) {

		ClassRoom room1 = new ClassRoom();
		fillClass(room1);
		System.out.println("room1");
		room1.showClassRoom();
		
	}

	public static void fillClass(ClassRoom room) {
		boolean notFull = true;
		while (notFull) {
			notFull = room.addStudent(getRandomStudent());
		}
		room.setTeacher(getRandomTeacher());
//		System.out.println(room.getTeacher());
	}

	private static Student getRandomStudent() {
		Name name = Name.values()[(int) (Math.random() * Name.values().length)]; // random enum Name;
		int id = (int) (Math.random() * 101) + 100; // 100-200
		int age = (int) (Math.random() * 11) + 10; // 10-20
		return new Student(name, id, age);
	}

	public static Teacher getRandomTeacher() {
		Name name = Name.values()[(int) (Math.random() * Name.values().length)]; // random enum Name;
		int id = (int) (Math.random() * 101) + 100; // 100-200
		int age = (int) (Math.random() * 46) + 20; // 20-65
		Degree degree = Degree.values()[(int) (Math.random() * Degree.values().length)]; // random enum Degree;
		return new Teacher(name, id, age, degree);
	}

}
