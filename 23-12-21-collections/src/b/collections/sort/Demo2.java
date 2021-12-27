package b.collections.sort;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {

	public static void main(String[] args) {

		List<Person> list = new ArrayList<>();
		list.add(new Person(105, "Chana", 36));
		list.add(new Person(101, "David", 22));
		list.add(new Person(107, "Betty", 11));
		list.add(new Person(103, "Ariana", 53));
		
		System.out.println("insert order");
		System.out.println(list); // print

		System.out.println("natural order");
		list.sort(null); // sort 1
//		Collections.sort(list); // sort 2
		
		System.out.println("other order - name");
		PersonNameComparator comparator = new PersonNameComparator();
		System.out.println(list); // print again

	}

}
