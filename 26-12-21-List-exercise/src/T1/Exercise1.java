package T1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercise1 {
	
	public static void main(String[] args) {
		// create a list with 3 values
		List<Integer> list = new ArrayList<>();
		list.add(13);
		list.add(5);
		list.add(34);
		
		// print list
		System.out.println("list: " + list);
		
		// print 3rd element
		System.out.println("element 3: " + list.get(2));
		
		// print sum of all elements
//		System.out.println(list.size());
		int sum = 0;
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			sum += integer;
		}
		System.out.println("sum: " + sum);
		
		// print average of all elements
		double avg;
		/*
		avg = 0;
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			avg += integer;
		}
		*/
		avg = sum;
		avg = avg/list.size();
		System.out.println("average: " + avg);
	
	}
	

}
