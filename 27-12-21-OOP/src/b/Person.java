package b;

public abstract class Person {
	
	private Name name;
	private int id;
	private int age;
	
	public enum Name {
		BILL,
		
		WENDY,
		
		MIKE,
		
		SARA
	}
	
	public Person() {
		super();
	}
	
	public Person(Name name, int id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
	
	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
		
	
	@Override
	public String toString() {
		return "Person [Name=" + name + ", Id=" + id + ", Age=" + age + "]";
	}

	
	
}
