package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Coupon;
import app.core.repositories.CouponRepo;

@SpringBootApplication
public class Application4 {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application4.class, args);

		CouponRepo couponRepo = ctx.getBean(CouponRepo.class);
		
//		couponRepo.deleteById(1);
		
		Coupon coupon = couponRepo.findById(2).get();
		System.out.println(coupon);
		// if lazy initialization, couponRepo session is over already, if no optional will throw exception
		// if eager getReviews will work
		System.out.println(coupon.getReviews()); 
		
		
	}

}
