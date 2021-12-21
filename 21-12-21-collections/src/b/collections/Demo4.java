package b.collections;

import java.util.HashMap;
import java.util.Map;

public class Demo4 {

	public static void main(String[] args) {
		
		Map<String, String> dictionary = new HashMap<>();
		dictionary.put("Java", "a programming language");
		dictionary.put("Table", "a piece of furniture");
		dictionary.put("Dog", "an animal that barks");
		
		System.out.println("Dog" + ": " + dictionary.get("Dog"));
		System.out.println("============================");

		for(String key: dictionary.keySet()) {
			System.out.println(key + ": " + dictionary.get(key));
		}
	}

}
