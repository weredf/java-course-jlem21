package e;

import java.io.Serializable;

// Serializabilty of a class is enabled by the class implementing the java.io.Serializable interface
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int age;
	// transient fields are not serialized
	private transient String address;

	public Person() {
		super();
	}

	public Person(int id, String name, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	

}
