package c;

public class TestPerson {

	public static void main(String[] args) {
		System.out.println("start");
		Person p1 = new Person("aaa", 25);
		Person p2 = new Person("bbb", 55);
		Person p3 = new Person("ccc", 22);
		
//		Person.getCounter() = -500; // changing counter unwanted! private, getter necessary
//		System.out.println(Person.counter);
		
		System.out.println("counter: " + Person.getCounter()); // static reference
		System.out.println("id: " + p2.id);
		System.out.println("name: " + p2.getName()); // dynamic reference
		System.out.println("age: " + p2.getAge());
		System.out.println(p1.id + ", " + p3.id);
	}

}
