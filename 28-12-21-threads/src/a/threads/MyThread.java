package a.threads;


public class MyThread extends Thread{

//	Boolean interrupted;

	public MyThread(String name) {
		super(name);
	}
	
	
	@Override
	public void run() {
		for (int i = 1; i <= 1000; i++) {
			System.out.println(getName() + ":" + i);
		}

	}
}
