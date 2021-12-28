package b;

public class Teacher extends Person{

	private Degree degree;

	public enum Degree {
		MED, BED
	}
	
	public Teacher() {
	}


	public Teacher(Name name, int id, int age, Degree degree) {
		super(name, id, age);
		this.degree = degree;
	}


	/**
	 * @return the degree
	 */
	public Degree getDegree() {
		return degree;
	}


	/**
	 * @param degree the degree to set
	 */
	public void setDegree(Degree degree) {
		this.degree = degree;
	}


	@Override
	public String toString() {
		return "Teacher [Degree=" + degree + ", Name=" + getName() + ", Id=" + getId() + ", Age="
				+ getAge() + "]";
	}
	
	

	
}
