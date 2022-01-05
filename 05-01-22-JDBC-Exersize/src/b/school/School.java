package b.school;

import java.util.Objects;

public class School {
	
	private int id;
	private String name;
	private String address;
	private Student[] students;
	
	public School() {
		
	}
	
	public School(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public School(int id, String name, String address, Student[] students) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof School))
			return false;
		School other = (School) obj;
		return Objects.equals(address, other.address) && id == other.id && Objects.equals(name, other.name);
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}
	
	
}
