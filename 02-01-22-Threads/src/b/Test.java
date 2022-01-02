package b;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		StopThread st = new StopThread();

		st.start();

		Thread.sleep(5000); // stops current thread, here main waits 5 seconds

		st.interrupt();
	}

}
