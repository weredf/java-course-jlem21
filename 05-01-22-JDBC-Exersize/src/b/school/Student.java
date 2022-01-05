package b.school;

import java.util.Objects;

public class Student {

	private int id;
	private int schoolId;
	private String name;
	private String email;
	
	public Student(int id, int schoolId, String name, String email) {
		super();
		this.id = id;
		this.schoolId = schoolId;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", schoolId=" + schoolId + ", name=" + name + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, schoolId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
				&& schoolId == other.schoolId;
	}
	
	
}
