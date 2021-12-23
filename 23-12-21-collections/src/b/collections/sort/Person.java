package b.collections.sort;

public class Person implements Comparable<Person>{
	
	private int id;
	private String name;
	private int age;
	
	@Override
	public int compareTo(Person other) {
		if(this.id < other.id) {
			return -1;
		} else if (this.id > other.id){
			return 1;
		}
		return 0;
	}

	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
	
	

}
