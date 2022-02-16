package app.core;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.repositories.CouponRepo;
import app.core.repositories.CustomerRepo;

@SpringBootApplication
public class Application2 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application2.class, args);
		
		CouponRepo couponRepo = ctx.getBean(CouponRepo.class);
		CustomerRepo customerRepo = ctx.getBean(CustomerRepo.class);
		
		// get the customer or throw an exception (instead of using optional)
		try {
			int customerId = 1;
			Customer customer = customerRepo.findById(customerId).orElseThrow();
			
			List<Coupon> coupons = new ArrayList<>();
			coupons.add(new Coupon(0, "Food", null, null));
			coupons.add(new Coupon(0, "Electronics", null, null));
			coupons.add(new Coupon(0, "Vacation", null, null));
			
			customer.setCoupons(coupons); // replaces the coupons the customer previously had, need additional method add
			
			customerRepo.save(customer);
			
//			System.out.println(customer);
//			System.out.println(customer.getCoupons());
//			System.out.println(couponRepo.findByCustomersId(customerId));
		} catch (NoSuchElementException e){
			System.out.println("Not found: " + e.getMessage());
		}
		
		
		
	}

}
