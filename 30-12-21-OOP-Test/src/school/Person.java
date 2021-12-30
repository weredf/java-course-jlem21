package school;

public class Person {
	
	private String name;
	public static final int MIN_AGE = 20;
	private int age = MIN_AGE;
	public static final int MAX_AGE = 120;
	
	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		if (age < MAX_AGE) {
			this.age = age;
		}
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	
}
