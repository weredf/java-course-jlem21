package a.threads;

public class Test {

	public static void main(String[] args) {

		// parallel run
		// start method
		MyThread mt1 = new MyThread("mt1");
//		mt1.start();
		MyThread mt2 = new MyThread("mt2");
//		mt2.start();
		MyThread mt3 = new MyThread("mt3");
//		mt3.start();
		MyThread mt4 = new MyThread("mt4");
//		mt4.start();
		MyThread mt5 = new MyThread("mt5");
//		mt5.start();
		
		Thread[] threads = {mt1, mt2, mt3, mt4, mt5};
		// for each loop starts every thread in the threads array
		for (Thread x : threads) {
			x.start();
		}
		
		
		// get a reference to the currently running thread
		Thread currThread = Thread.currentThread();
		
		// main method
		for (int i = 1; i <= 1000; i++) {
			System.out.println(currThread.getName() + ": " + i);
		}
	}

}
