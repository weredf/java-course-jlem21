package app.core.bean;

import app.core.proxy.PrinterInt;

/*
 * the printer class represents a business core concern
 */
public class Printer implements PrinterInt{

	@Override
	public void print(String text) {
		System.out.println("printing: " + text);
	}
	
	@Override
	public void sendFax() {
		System.out.println("sending fax");
	}
	
	@Override
	public void clearInk() {
		System.out.println("clearing ink");
	}
}
