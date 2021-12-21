package b.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Demo5 {

	public static void main(String[] args) {
		
		Map<String, String> dictionary2 = new TreeMap<>();
		dictionary2.put("Pizza", "a tasty Italian dish");
		dictionary2.put("Chair", "a piece of furniture");
		dictionary2.put("Cat", "an animal that meows");
		
		System.out.println(dictionary2);
		System.out.println("============================");
		
		System.out.println("Cat" + ": " + dictionary2.get("Cat"));
		System.out.println("============================");

		Collection<String> values = dictionary2.values();
		for (String val : values) {
			System.out.println(val);
		}
		System.out.println("============================");

		Set<String> keys = dictionary2.keySet();
		for (String key: keys) {
			System.out.println(key);
		}
		System.out.println("============================");
		
		for(String key: dictionary2.keySet()) {
			System.out.println(key + ": " + dictionary2.get(key));
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter word: ");
		String key = sc.nextLine();
		if(dictionary2.containsKey(key)) {
			System.out.println("definition: ");
			System.out.println(dictionary2.get(key));
		}else {
			System.out.println("sorry, " + key + " is not in the dictionary");
		}
		sc.close();
	}

}
