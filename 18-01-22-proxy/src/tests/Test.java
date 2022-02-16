package tests;

import app.core.proxy.PrinterStatisticsProxy;

public class Test {

	public static void main(String[] args) {
		PrinterStatisticsProxy printer = new PrinterStatisticsProxy();
		printer.clearInk();
		printer.sendFax();
		printer.sendFax();
		printer.print("Hello");
		printer.sendFax();
		
		System.out.println("number of fax sent: " + printer.getC());
	}
}
