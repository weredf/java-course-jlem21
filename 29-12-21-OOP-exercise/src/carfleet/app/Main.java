package carfleet.app;

public class Main {

	public static void main(String[] args) {

		Country country = new Country();
		createCountry(country);
		initializeCountry(country);
		showCountry(country);

		System.out.println("=======================================================");
		System.out.println("Total amount of cars in country: " + amountCars(country));
		/*
		// alternative methods from class country and highway	
		System.out.println(country.getNumberOfCars());
		for (Highway h : country.getHighways()) {
			if (h!=null) {
			System.out.println(h.getName() + ", number of cars: " + h.getNumberOfCars());
			}
		}
		*/
		System.out.println("=======================================================");
		System.out.println("Average speed in country: " + avgSpeed(country));
		System.out.println("=======================================================");
		System.out.println("Max speed in country: " + maxSpeed(country));
		System.out.println("=======================================================");
		System.out.println("Busiest highway in country: " + busyHighway(country));
		
	}

	// fill country with highways
	private static void createCountry(Country country) { 
		for (int i = 0; i < country.getHighways().length; i++) {
			Highway highway = new Highway("Highway" + (i + 1));
			country.addHighways(highway);
		}
	}

	// fill every highway with cars
	private static void initializeCountry(Country country) { 
		for (int i = 0; i < country.getHighways().length; i++) {
			int lengthCars = (int)(Math.random() * country.getHighways()[i].getCars().length);
			System.out.println("Amount of cars waiting to go on Highway" + (i + 1) + ": " + lengthCars);
			for (int j = 0; j < lengthCars; j++) {
				int speed = (int) (Math.random() * 131); // 111-130 is illegal speed
				Car car = null;
				if (Math.random() > 0.5) {
					car = new FamilyCar(j + 1, speed);
				} else {
					car = new SportsCar(j + 1, speed);
				}
				country.getHighways()[i].addCar(car);
			}
		}
	}

	// print all highway arrays in country
	private static void showCountry(Country country) { 
		for (int i = 0; i < country.getHighways().length; i++) {
			System.out.println(country.getHighways()[i]);
		}
	}

	// counter amount of cars in every highway
	private static int amountCarsInHighway(Highway highway) { 
		int amount = 0;
		for (int i = 0; i < highway.getCars().length; i++) {
			if (highway.getCars()[i] != null) {
				amount++;
			}
		}
		return amount;
	}

	// counter summing up all cars from all highways
	private static int amountCars(Country country) { 
		int amount = 0;
		for (int i = 0; i < country.getHighways().length; i++) {
			int amountTemp = amountCarsInHighway(country.getHighways()[i]);
			System.out.println(country.getHighways()[i].getName() + ", amount of cars: " + amountTemp);
			amount+=amountTemp;
		}
		return amount;
	}

	// average speed per highway
	private static double avgSpeedinHighway(Highway highway) { 
		int sum = 0;
		int count = 0;
		for (int i = 0; i < highway.getCars().length; i++) {
			if(highway.getCars()[i] != null) {
				sum += highway.getCars()[i].getSpeed();
				count++;
			}
		}
		if(count>0) {
			return sum/count;			
		}
		return 0;
	}
	
	// average of average speeds per highway
	private static double avgSpeed(Country country) { 
		double sum = 0;
		int count = 0;
		double maxAvg = 0;
		String highwayMaxAvg = "";
		
		for (int i = 0; i < country.getHighways().length; i++) {
			double avgSpeedinHighway = avgSpeedinHighway(country.getHighways()[i]);
			System.out.println(country.getHighways()[i].getName() + ": Average speed is " + (int)avgSpeedinHighway);
			if(avgSpeedinHighway > maxAvg) {
				maxAvg = avgSpeedinHighway;
				highwayMaxAvg = country.getHighways()[i].getName();
			}
			sum += avgSpeedinHighway;
			count++;
		}
		System.out.println("Highway with highest average: " + highwayMaxAvg + ", average speed " + (int)maxAvg);
		return sum/count;
	}

	// highest speed on highway
	private static int maxSpeedinHighway(Highway highway) { 
		int maxSpeed = 0;
		for(int i = 0; i < highway.getCars().length; i++) {
			if(highway.getCars()[i] != null) {
				if(highway.getCars()[i].getSpeed() > maxSpeed) {
					maxSpeed = highway.getCars()[i].getSpeed();
				}				
			}
		}
		return maxSpeed;
	}
	
	// highest speed in all highways
	private static int maxSpeed(Country country) { 
		int maxSpeed = 0;
		for (int i = 0; i < country.getHighways().length; i++) {
			int maxSpeedHighway = maxSpeedinHighway(country.getHighways()[i]);
			System.out.println(country.getHighways()[i].getName() + ": max speed is " + maxSpeedHighway);
			if(maxSpeedHighway>maxSpeed) {
				maxSpeed = maxSpeedHighway;
			}
		}
		return maxSpeed;
	}

	// find highway with the most cars
	private static String busyHighway(Country country) { 
		int maxCars = 0;
		String nameHighwayMaxCars = "";
		for(int i = 0; i < country.getHighways().length; i++) {
			int cars = 0;
			for(int j = 0; j < country.getHighways()[i].getCars().length; j++) {
				if(country.getHighways()[i].getCars()[j]  != null) {
					cars++;
				}
			}
			if(cars > maxCars) {
				maxCars = cars;
				nameHighwayMaxCars = country.getHighways()[i].getName();
			}
		}
		
		return nameHighwayMaxCars;
	}

}