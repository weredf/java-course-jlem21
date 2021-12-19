package c;

public class Person {

	// fields (attributes, variables)
	
	// instance variables
	public final int id; // final cannot be reassigned
	private String name;
	private int age;
	// class variables
	private static int counter;
	// constant (static + final), like PI
	public static final int MAX_AGE = 120;
	
	static{ // static initializer - runs on class load, only once
		System.out.println("class loaded - counter set to " + counter);
		if (Math.random() < 0.5) {
			counter = 100;
		} else {
			counter = 1000;
		}
	}

	{ // initializer - runs on object creation before CTOR (pre-constructor)
		System.out.println("person created");
		counter++; // static counter belongs to the class, not the object
		this.id = counter; // id is assigned and locked on this value

	}

	public Person(String name, int age) {
		super();
		this.name = name;
		setAge(age);
	}

	public Person() {

	}

	// class method (static)
	public static int getCounter() {
		return counter;
	}

	// instance methods (non static)
	/*
	 * public int getId() { // no longer necessary now that id is final return id; }
	 */

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

//	public void setId(int id) { // final, can not longer change, no setter
//		this.id = id;
//	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		if (age <= MAX_AGE) {
			this.age = age;
		}
	}

}
