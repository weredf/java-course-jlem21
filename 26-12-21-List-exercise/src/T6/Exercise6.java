package T6;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Exercise6 {

	public static void main(String[] args) {

		Map<Character, Integer> ABC = new LinkedHashMap<>();
		ABC.put('A', 65);
		ABC.put('B', 66);
		ABC.put('C', 67);
		
		System.out.println(ABC);
		System.out.println(ABC.keySet());
		System.out.println(ABC.values());
		System.out.println("==================================");
		
		Map<Integer, String> days = new HashMap<>();
		days.put(1, "Sunday");
		days.put(2, "Monday");
		days.put(3, "Tuesday");
		
		System.out.println(days);
		System.out.println(days.keySet());
		System.out.println(days.values());
		System.out.println("==================================");
		
		Map<Integer, String> numbers = new HashMap<>();
		numbers.put(1, "one");
		numbers.put(2, "two");
		numbers.put(3, "three");
		numbers.put(4, "four");
		numbers.put(5, "five");
	
		System.out.println(numbers);
		System.out.println(numbers.keySet());
		System.out.println(numbers.values());
		System.out.println("==================================");
	}

}
