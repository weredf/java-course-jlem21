package T2;

import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i<100; i++) {
			list.add((int)(Math.random()*61)+20);
		}
		
		System.out.println(list);
		
		// print amount of elements in list
		System.out.println("number of elements: " + list.size());
		System.out.println("=========");
		
		//print 1st element
		System.out.println("first element: " + list.get(0));
		System.out.println("=========");
		
		// print last element
		System.out.println("last element: " + list.get(99));
		System.out.println("=========");
		
		// print 10th element
		System.out.println("10th element: " + list.get(9));
		System.out.println("=========");
		
		// does the element 25 occur, if so print index number
		/*
		for (int i = 0; i<100; i++) {
			if (list.get(i) == 25) {
				System.out.println(i);
			}
		}
		*/
		boolean contains = list.contains(25);
		System.out.println("contains 25?: " + contains);
		if (contains) {
			System.out.println("index number: " + list.indexOf(25));
		}
		System.out.println("=========");
	}

}
