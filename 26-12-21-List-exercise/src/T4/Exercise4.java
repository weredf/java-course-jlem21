package T4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Exercise4 {
	
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		set.add("Ben");
		set.add("Dinah");
		set.add("Rachel");
		
		System.out.println(set);
		
		// hashset has no index, use iterator to get to third element
		Iterator<String> iterator = set.iterator();
		for (int i = 0; iterator.hasNext(); i++) {
			String current = iterator.next();
			if(i == 2) {
				System.out.println(current);
				break;
			}
			
		}
		
	}

}
