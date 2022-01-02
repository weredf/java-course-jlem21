package d.gc;

public class Person {

	private static int NumberOfInstancesInMemory;
	private int id;
	private String name;

	// initializer runs for every CTOR
	{ // runs on object creation
		NumberOfInstancesInMemory++;
		this.id = NumberOfInstancesInMemory;
	}
	
	

	public Person(String name) {
		super();
		this.name = name;
	}


	// this method is called by Garbage Collector before recycling this object
	@Override
	protected void finalize() throws Throwable {
		System.out.println(name + " is finalized");
		NumberOfInstancesInMemory--;
	}


	public static int getNumberOfInstancesInMemory() {
		return NumberOfInstancesInMemory;
	}


	public static void setNumberOfInstancesInMemory(int numberOfInstancesInMemory) {
		NumberOfInstancesInMemory = numberOfInstancesInMemory;
	}


}
