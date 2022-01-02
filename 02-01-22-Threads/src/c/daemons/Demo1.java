package c.daemons;

import a.MyThread;

public class Demo1 {

	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread("t1");
		MyThread d1 = new MyThread("d1");
		d1.setDaemon(true); // runs in background of thread
		
		t1.start();
		d1.start();
		
		Thread.sleep(3000);
		t1.interrupt(); // when t1 ends, d1 (daemon) ends
		
		System.out.println("main ended");
	}
}
