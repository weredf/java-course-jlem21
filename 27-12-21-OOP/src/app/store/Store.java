package app.store;

public class Store {

	private Fruit[] fruits = new Fruit[100]; // fruit content of store
	private Vegetable[] vegetables = new Vegetable[100]; // vegetable content of store

	public boolean addFruit(Fruit fruit) {
		for (int i = 0; i < fruits.length; i++) {
			if (fruits[i] == null) {
				fruits[i] = fruit;
				return true; // when a fruit was added
			}
		}
		return false; // when array is full
	}

	public boolean addVegetable(Vegetable vegetable) {
		for (int i = 0; i < vegetables.length; i++) {
			if (vegetables[i] == null) {
				vegetables[i] = vegetable;
				return true;
			}
		}
		return false;
	}

	public void showStock() { // show contents of store
		System.out.println("==============================");
		System.out.println("Store stock: ");
		System.out.println("Fruits:");
		for (Fruit fruit : fruits) { // all
			System.out.println(fruit);
		}
		System.out.println();
		System.out.println("Vegetables: ");
		for (Vegetable vegetables : vegetables) {
			System.out.println(vegetables);
		}
		System.out.println("==============================");
	}

	// check heaviest food per class
	public int heaviestApple() {
		int max = 0;
		for (Fruit fruit : fruits) {
			if (fruit instanceof Apple) {
				if (fruit.getWeight() > max) {
					max = (int) fruit.getWeight();
				}
			}
		}
		return max;
	}

	public int heaviestStrawberry() {
		int max = 0;
		for (Fruit fruit : fruits) {
			if (fruit instanceof Strawberry) {
				if (fruit.getWeight() > max) {
					max = (int) fruit.getWeight();
				}
			}
		}
		return max;
	}

	public int heaviestFruit() {
		int a = heaviestApple();
		int b = heaviestStrawberry();
		if (a > b) {
			return a;
		} else {
			return b;
		}

	}

	public int heaviestCarrot() {
		int max = 0;
		for (Vegetable vegetable : vegetables) {
			if (vegetable instanceof Carrot) {
				if (vegetable.getWeight() > max) {
					max = (int) vegetable.getWeight();
				}
			}
		}
		return max;
	}

	public int heaviestTomato() {
		int max = 0;
		for (Vegetable vegetable : vegetables) {
			if (vegetable instanceof Tomato) {
				if (vegetable.getWeight() > max) {
					max = (int) vegetable.getWeight();
				}
			}
		}
		return max;
	}

	public int heaviestVegetable() {
		int a = heaviestCarrot();
		int b = heaviestTomato();
		if (a > b) {
			return a;
		} else {
			return b;
		}

	}

	// heaviest food total
	public int maxWeight() {
		int x = heaviestFruit();
		int y = heaviestVegetable();
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}

	// lightest food per class
	public int lightestApple() {
		int min = 500;
		for (Fruit fruit : fruits) {
			if (fruit instanceof Apple) {
				if (fruit.getWeight() < min) {
					min = (int) fruit.getWeight();
				}
			}
		}
		return min;
	}

	public int lightestStrawberry() {
		int min = 500;
		for (Fruit fruit : fruits) {
			if (fruit instanceof Strawberry) {
				if (fruit.getWeight() > min) {
					min = (int) fruit.getWeight();
				}
			}
		}
		return min;
	}

	public int lightestFruit() {
		int a = lightestApple();
		int b = lightestStrawberry();
		if (a > b) {
			return a;
		} else {
			return b;
		}

	}

	public int lightestCarrot() {
		int min = 500;
		for (Vegetable vegetable : vegetables) {
			if (vegetable instanceof Carrot) {
				if (vegetable.getWeight() > min) {
					min = (int) vegetable.getWeight();
				}
			}
		}
		return min;
	}

	public int lightestTomato() {
		int min = 500;
		for (Vegetable vegetable : vegetables) {
			if (vegetable instanceof Tomato) {
				if (vegetable.getWeight() > min) {
					min = (int) vegetable.getWeight();
				}
			}
		}
		return min;
	}

	public int lightestVegetable() {
		int a = lightestCarrot();
		int b = lightestTomato();
		if (a > b) {
			return a;
		} else {
			return b;
		}

	}
	// lightest food total
	public int minWeight() {
		int x = lightestFruit();
		int y = lightestVegetable();
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}
	// average weight

	// count food per class

	public int countApples() {
		int counterA = 0;
		for (Fruit fruit : fruits) {
			if (fruit instanceof Apple) {
				counterA++;
			}
		}
		return counterA;
	}

	public int countStrawberries() {
		int counterS = 0;
		for (Fruit fruit : fruits) {
			if (fruit instanceof Strawberry) {
				counterS++;
			}
		}
		return counterS;
	}

	public int countCarrots() {
		int counterC = 0;
		for (Vegetable vegetable : vegetables) {
			if (vegetable instanceof Carrot) {
				counterC++;
			}
		}
		return counterC;
	}

	public int countTomatoes() {
		int counterT = 0;
		for (Vegetable vegetable : vegetables) {
			if (vegetable instanceof Tomato) {
				counterT++;
			}
		}
		return counterT;
	}

}
