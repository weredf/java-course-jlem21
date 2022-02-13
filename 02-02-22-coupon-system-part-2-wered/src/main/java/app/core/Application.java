package app.core;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Category;
import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.exceptions.CouponSystemException;
import app.core.job.CouponExpirationDailyJob;
import app.core.login.ClientType;
import app.core.login.LoginManager;
import app.core.services.AdminService;
import app.core.services.CompanyService;
import app.core.services.CustomerService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		LoginManager loginManager = ctx.getBean(LoginManager.class);
		CouponExpirationDailyJob job = ctx.getBean(CouponExpirationDailyJob.class);
		job.run();
		
		try {
			AdminService adminService = (AdminService) loginManager.login("admin@admin.com", "admin",
					ClientType.ADMINISTRATOR);
			if (adminService != null) {
				adminService.addCompany(new Company(0, "AAA", "aaa@mail.com", "aaaPass", null));
				System.out.println(adminService.getOneCompany(1));
				adminService.addCompany(new Company(0, "BBB", "bbb@mail.com", "bbbPass", null));
				adminService.updateCompany(new Company(2, "CCC", "ccc@mail.com", "cccPass", null));
				System.out.println(adminService.getAllCompanies());
				adminService.deleteCompany(2);
				adminService.addCustomer(new Customer(0, "ddd", "DDD", "ddd@mail.com", "dddPass", null));
				System.out.println(adminService.getOneCustomer(1));
				adminService.addCustomer(new Customer(0, "eee", "EEE", "eee@mail.com", "eeePass", null));
				adminService.updateCustomer(new Customer(2, "fff", "FFF", "fff@mail.com", "fffPass", null));
				System.out.println(adminService.getAllCustomers());
//				adminService.deleteCustomer(2);
			} else {
				System.out.println("login failed");
			}
			
			CompanyService companyService = (CompanyService) loginManager.login("aaa@mail.com", "aaaPass", ClientType.COMPANY);
			if (companyService != null) {
				System.out.println("logged in as company id: " + companyService.getCompanyDetails().getId());
				companyService.addCoupon(new Coupon(0, companyService.getCompanyDetails(), Category.FOOD, "10%", "10% discount on food", LocalDate.of(2021, 3, 1), LocalDate.of(2022, 5, 1), 5, 10.9, "image", null));
				System.out.println(companyService.getCompanyCoupons(11));
				companyService.addCoupon(new Coupon(0, companyService.getCompanyDetails(), Category.VACATION, "15%", "15% discount on vacation", LocalDate.of(2021, 10, 1), LocalDate.of(2022, 3, 1), 10, 22.5, "image", null));
				System.out.println(companyService.getCompanyCoupons(Category.VACATION));
				companyService.updateCoupon(new Coupon(2, companyService.getCompanyDetails(), Category.FOOD, "15%", "15% discount on food", LocalDate.of(2021, 10, 1), LocalDate.of(2022, 2, 1), 10, 22.5, "image", null));
				System.out.println(companyService.getCompanyCoupons());
//				companyService.deleteCoupon(2);
			} else {
				System.out.println("login failed");
			}
			
			{
				CustomerService customerService = (CustomerService) loginManager.login("ddd@mail.com", "dddPass", ClientType.CUSTOMER);
				if (customerService != null) {
					System.out.println("logged in as customer id: " + customerService.getCustomerDetails().getId());
					customerService.purchaseCoupon(new Coupon(1, new Company(1, null, null, null, null), Category.FOOD, "10%", "10% discount on food", LocalDate.of(2021, 3, 1), LocalDate.of(2022, 5, 1), 5, 10.9, "image", null));
//					customerService.purchaseCoupon(null);
					System.out.println(customerService.getCustomerCoupons(20));
					System.out.println(customerService.getCustomerCoupons(Category.FOOD));
					System.out.println(customerService.getCustomerCoupons());
				}
			}
			
		} catch (CouponSystemException e) {
			e.printStackTrace();
		}
		
		{
			try {
				TimeUnit.SECONDS.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
