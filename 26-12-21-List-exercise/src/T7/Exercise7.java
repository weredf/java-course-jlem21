package T7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise7 {

	public static void main(String[] args) {

		Map<String, String> dictionary = new HashMap<>();
		dictionary.put("dog", "an animal that barks");
		dictionary.put("car", "a vehicle");
		dictionary.put("java", "a programming language");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter word: ");
		String key = sc.nextLine();
		if(dictionary.containsKey(key)) {
			System.out.println("definition: ");
			System.out.println(dictionary.get(key));
		}else {
			System.out.println("sorry, " + key + " is not in the dictionary");
		}
		sc.close();
	}

}
