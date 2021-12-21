package a;

public class PersonTest {

	public static void main(String[] args) {
		Person p = new Person();
		try {
			int age = (int)(Math.random()*201);
			p.setAge(age);
		} catch (PersonAgeException e) {
			System.out.println(e.getMessage());
//			e.printStackTrace(); prints locations where fail coded
		}
		System.out.println(p.getAge());
		System.out.println("END");
	}

}
