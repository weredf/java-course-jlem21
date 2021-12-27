package app.store.main;

import app.store.Apple;
import app.store.Carrot;
import app.store.Store;
import app.store.Strawberry;
import app.store.Tomato;
import app.store.Vegetable;
import app.store.Food.Taste;
import app.store.Fruit;

public class StoreStatistics {

	public static void main(String[] args) {
		Store store = new Store();
		fillStore(store);
		store.showStock();

		System.out.println("Heaviest apple in the store: " + store.heaviestApple());
		System.out.println("Heaviest strawberry in the store: " + store.heaviestStrawberry());
		System.out.println("Heaviest fruit in the store: " + store.heaviestFruit());
		System.out.println("Heaviest food in the store: " + store.maxWeight());
		System.out.println("Store contents: " + store.countApples() + " Apples, " + store.countStrawberries()
				+ " Strawberries, " + store.countCarrots() + " Carrots, " + store.countTomatoes() + " Tomatoes.");

//		System.out.println(Arrays.toString(store.getFruits()));
//		System.out.println(Arrays.toString(store.getVegetables()));

	}

	public static void fillStore(Store store) {
		boolean notFull = true;
		while (notFull) {
			notFull = store.addFruit(getRandomFruit());
		}
		notFull = true;
		while (notFull) {
			notFull = store.addVegetable(getRandomVegetable());
		}

		/*
		 * for (int i = 0; i <= 200; i++) { int x = (int)(Math.random()*4)+1; if (x==1)
		 * { store.addFruit(new Strawberry(50, Taste.SWEET)); }else if (x==2){ //
		 * store.addFruit(new Apple((Math.random()*100)+100, Taste.SWEET, Taste.SOUR));
		 * store.addFruit(new Apple((Math.random()*100)+100, Taste.SOUR)); }else if
		 * (x==3) { // store.addVegetable(new Carrot(100, Taste.SWEET, Taste.BITTER));
		 * store.addVegetable(new Carrot(100, Taste.BITTER)); }else if (x==4) {
		 * store.addVegetable(new Tomato((Math.random()*50)+50, Taste.SOUR)); }
		 * 
		 * }
		 */

	}

	public static Fruit getRandomFruit() {
		if (Math.random() < 0.5) {
			Taste taste = Taste.values()[(int) (Math.random() * (Taste.values().length) - 1)]; // random enum Taste
																								// value 1 or 2
			int weight = (int) (Math.random() * 201) + 100; // 100-300
			return new Apple(weight, taste);
		} else {
			Taste taste = Taste.values()[0]; // only Sweet
			int weight = (int) (Math.random() * 51) + 50; // 50-100
			return new Strawberry(weight, taste);
		}

	}

	public static Vegetable getRandomVegetable() {
		if (Math.random() < 0.5) {
			Taste taste = Taste.values()[(int) (Math.random() * (Taste.values().length) - 1)]; // random enum Taste
																								// value 1-3
			int weight = (int) (Math.random() * 201) + 100; // 100-300
			return new Carrot(weight, taste);
		} else {
			Taste taste = Taste.values()[(int) (Math.random() * (Taste.values().length) - 1)]; // random enum Taste
																								// value 1 or 2
			int weight = (int) (Math.random() * 101) + 100; // 100-200
			return new Tomato(weight, taste);
		}

	}

}
