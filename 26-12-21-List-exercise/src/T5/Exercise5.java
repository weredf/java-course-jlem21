package T5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Exercise5 {

	public static void main(String[] args) {
		// populate set with 10 numbers (0-10)
		Set<Integer> set = new HashSet<Integer>();
		while (set.size() < 10) {
			set.add((int) (Math.random() * 11));
		}
		System.out.println(set);

		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			if (iterator.next() % 2 == 0) {
				iterator.remove();
			}
		}
		System.out.println(set);
	}

}
