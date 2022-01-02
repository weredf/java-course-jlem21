package f.waitAndNotify;

public class Consumer extends Thread{
	
	private Stack stack;

	// CTOR
	public Consumer(String name, Stack stack) {
		super(name);
		this.stack = stack;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			int r = stack.pop();
			System.out.println("\t" + getName() + " popped: " + r);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	

}
