package T3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise3 {

	public static void main(String[] args) {

		// new list, 10 elements (5-10)
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add((int) (Math.random() * 6) + 5); // 5-10
		}

		System.out.println(list);

		// new set, add all list elements, get unique numbers
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < list.size(); i++) {
			set.add(list.get(i));
		}

		System.out.println(set);
		
		// clear list, add unique numbers from set
		list.clear();
		list.addAll(set);
		System.out.println(list);

	}

}
