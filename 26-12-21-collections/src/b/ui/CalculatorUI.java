package b.ui;

import java.util.Scanner;

public class CalculatorUI {
	
	private Calculator calculator = new Calculator();
	private Scanner sc = new Scanner(System.in);
	private boolean systemOn;
	
	public void start() {
		systemOn = true;
		while (systemOn) {
			try {
				printMenu();
				String command = sc.nextLine();
				switch(command) {
				case "+":
					doAdd();
					break;
				case "-":
					doSub();
					break;
				case "*":
					doMul();
					break;
				case "/":
					doDiv();
					break;
				case "cl":
					doClr();
					break;
				case "=":
					doGet();
					break;
				case "q":
				case "x":
					systemOn = false;
					break;
				default:
					System.out.println(command + " is not a supported action");
				}
				
			} catch (Exception e) {
				System.err.println("ERROR: " + e.getMessage());
			}
		}
		sc.close();
	}

	private void doGet() {
		System.out.println("result: " + calculator.getRes());
	}

	private void doClr() {
		this.calculator.clear();
		System.out.println("result cleared");		
	}

	private void doDiv() {
		System.out.print("enter value to divide: ");
		Double val = Double.parseDouble(sc.nextLine());
		this.calculator.div(val);
		System.out.println("divided: " + val);		
	}

	private void doMul() {
		System.out.print("enter value to multiply: ");
		Double val = Double.parseDouble(sc.nextLine());
		this.calculator.mul(val);
		System.out.println("multiplied: " + val);		
	}

	private void doSub() {
		System.out.print("enter value to subtract: ");
		Double val = Double.parseDouble(sc.nextLine());
		this.calculator.sub(val);
		System.out.println("subtracted: " + val);
	}

	private void doAdd() {
		System.out.print("enter value to add: ");
		Double val = Double.parseDouble(sc.nextLine());
		this.calculator.add(val);		
		System.out.println("added: " + val);
	}

	private void printMenu() {
		System.out.println("\n== Menu =========");
		System.out.println("Add .......... +");
		System.out.println("Subtract ..... -");
		System.out.println("Multiply ..... *");
		System.out.println("Divide ....... /");
		System.out.println("Clear ........ cl");
		System.out.println("Get results .. =");
		System.out.println("Exit ......... q / x");
		System.out.print("Enter choice: ");		
	}

}
