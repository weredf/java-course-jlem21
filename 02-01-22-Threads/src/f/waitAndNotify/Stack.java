package f.waitAndNotify;

import java.util.ArrayList;
import java.util.List;

public class Stack {

	private List<Integer> list = new ArrayList<Integer>();
	public static final int MAX = 10;

	// push - add an element to a stack
	public synchronized void push(Integer val) {
		while (list.size() == MAX) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		list.add(val); // add an element to the end of the list
		System.out.println(list);
		notify(); // notify of addition
	}

	// pop - take an element out of a stack
	public synchronized Integer pop() {
		while (list.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int val = list.remove(list.size() - 1); // last index number is size-1 since first index number is 0
		System.out.println(list);
		notify();
		return val;
	}

}
