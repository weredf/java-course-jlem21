package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.repositories.CouponRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		CouponRepo couponRepo = ctx.getBean(CouponRepo.class);
		
		Coupon coupon = new Coupon(0, "AAA", null, null);
		
		Customer customer1 = new Customer(0, "Avi", "avi@mail.com", null);
		Customer customer2 = new Customer(0, "Max", "max@mail.com", null);
		Customer customer3 = new Customer(0, "Ingrid", "ingrid@mail.com", null);
		
		coupon.addCustomer(customer1); // add customer who bought this coupon
		coupon.addCustomer(customer2);
		coupon.addCustomer(customer3);

		couponRepo.save(coupon);
		System.out.println();
		
		
	}

}
