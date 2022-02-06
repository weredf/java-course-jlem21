package app.core;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Category;
import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.exceptions.CouponSystemException;
import app.core.repos.CompanyRepo;
import app.core.repos.CustomerRepo;
import app.core.services.AdminService;
import app.core.services.ClientService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		{
			CompanyRepo companyRepo = ctx.getBean(CompanyRepo.class);
			CustomerRepo customerRepo = ctx.getBean(CustomerRepo.class);
		
			Company company = new Company(0, "AAA", "aaa@mail.com", "aaaPass", null);
			Coupon coupon = new Coupon(0, company, Category.FOOD, "10%", "10% discount on food", LocalDate.of(2021, 3, 1), LocalDate.of(2022, 5, 1), 5, 10.9, "image", null, null);
			company.addCoupon(coupon);
			Customer customer = new Customer(0, "ppp", "PPP", "ppp@mail.com", "pppPass", null);
			customer.addCoupon(coupon);
			coupon.addCustomer(customer);
			companyRepo.save(company);
			customerRepo.save(customer);
		}
		
		{
			ClientService adminService = new AdminService();
			try {
				Boolean login = adminService.login("admin@admin.com", "admin");
				System.out.println(login);
			} catch (CouponSystemException e) {
				e.printStackTrace();
			}
		}
	}

}
