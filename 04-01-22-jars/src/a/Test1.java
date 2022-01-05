package a;

import api.converters.currency.CurrencyConverter;
import api.converters.temperature.TemperatureConverter;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("start test");
		System.out.println();
		
		double nis = 100;
		float dollar = (float) CurrencyConverter.convertNISToDollar(nis);
		System.out.println(nis + " NIS is " + String.format("%.2f", dollar) + " dollar.");
		
		double celsius = 8;
		double fahrenheit = TemperatureConverter.convertCelsiusToFahrenheit(celsius);
		System.out.println(celsius + " degrees Celsius is " + fahrenheit + " degrees Fahrenheit.");
		
	}

}
