package app.core.proxy;

import app.core.bean.Printer;

public class PrinterStatisticsProxy implements PrinterInt{

	private PrinterInt p = new Printer();
	int c;
	
	@Override
	public void print(String text) {
		p.print(text);
	}

	@Override
	public void sendFax() {
		p.sendFax();
		c++;
	}

	@Override
	public void clearInk() {
		p.clearInk();
		System.out.println(">>> proxy clear success");
	}

	public int getC() {
		return c;
	}

	
}
