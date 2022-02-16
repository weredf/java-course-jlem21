package app.core;

import javax.swing.JOptionPane;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.CalculatorBeanInterface;
import app.core.log.LoginManager;

public class App3 {

	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
			
			LoginManager loginManager = ctx.getBean(LoginManager.class);
			boolean logged = loginManager.login("admin", "1234");
			System.out.println(logged);
			System.out.println(loginManager.isLogged());
			
			CalculatorBeanInterface calc = ctx.getBean(CalculatorBeanInterface.class);
			
			int a = Integer.parseInt(JOptionPane.showInputDialog("enter first number"));
			int b= Integer.parseInt(JOptionPane.showInputDialog("enter second number"));
			
			try {
				String res = calc.div(a, b);
				System.out.println("Main: " + res);
			} catch (Exception e){
				System.out.println("Error: " + e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}
