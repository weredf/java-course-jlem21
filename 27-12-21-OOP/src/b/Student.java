package b;

public class Student extends Person{

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Name name, int id, int age) {
		super(name, id, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [Name=" + getName() + ", Id=" + getId() + ", Age="
				+ getAge() + "]";
	}

	
}
