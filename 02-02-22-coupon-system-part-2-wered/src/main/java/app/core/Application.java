package app.core;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Category;
import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.repos.CompanyRepo;
import app.core.repos.CouponRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		CompanyRepo companyRepo = ctx.getBean(CompanyRepo.class);
		Company c = new Company(0, "AAA", "aaa@mail.com", "aaaPass", null);
		companyRepo.save(c);
//		companyRepo.save(new Company(0, "AAA", "aaa@mail.com", "aaaPass", null));
		CouponRepo couponRepo = ctx.getBean(CouponRepo.class);
//		couponRepo.save(new Coupon(0, companyRepo.findById(1).get(), Category.FOOD, "10%", "10% discount on food", LocalDate.of(2021, 3, 1), LocalDate.of(2022, 5, 1), 5, 10.9, "image", null));
		Coupon coupon = new Coupon(0, c, Category.FOOD, "10%", "10% discount on food", LocalDate.of(2021, 3, 1), LocalDate.of(2022, 5, 1), 5, 10.9, "image", null);
		couponRepo.save(coupon);
	}

}
