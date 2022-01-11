package app.core.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Scope("singleton") // default

@Component
@Scope("prototype")
public class Person {
	
	private int id;
	private String name;
	private int age;
	
	{
		System.out.println("Person created");
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
