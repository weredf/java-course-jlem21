package api.converters.temperature;

public class TemperatureConverter {

	public static double convertCelsiusToFahrenheit(double celsius) {
		double fahrenheit = celsius * 1.8 + 32;
		return fahrenheit;
	}

	public static double convertFahrenheitToCelsius(double fahrenheit) {
		double celsius = (fahrenheit - 32) / 1.8;
		return celsius;
	}
}
