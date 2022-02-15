package app.core.tests;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import app.core.entities.Category;
import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.exceptions.CouponSystemException;
import app.core.login.ClientType;
import app.core.login.LoginManager;
import app.core.services.AdminService;
import app.core.services.CompanyService;
import app.core.services.CustomerService;

@Component
@EnableScheduling
public class Test {

	@Autowired
	private LoginManager loginManager;

	@PostConstruct
	public void testAll() throws CouponSystemException {
		System.out.println("=== testAll started");
		try {
			testAdmin();
			testCompany();
			testCustomer();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				TimeUnit.SECONDS.sleep(20);
			} catch (InterruptedException e) {
				throw new CouponSystemException("Interrupted ", e);
			}
		}
		System.out.println("=== testAll ended");

	}

	private void testAdmin() throws CouponSystemException {
		System.out.println("=== testAdmin started");
		try {
			AdminService adminService = (AdminService) loginManager.login("admin@admin.com", "admin",
					ClientType.ADMINISTRATOR);
			if (adminService != null) {
				System.out.println("Logged in as Administrator");
				System.out.println("Company added, id: "
						+ adminService.addCompany(new Company(0, "AAA", "aaa@mail.com", "aaaPass", null)));
				System.out.println("First company: " + adminService.getOneCompany(1));
				System.out.println("Company added, id: "
						+ adminService.addCompany(new Company(0, "BBB", "bbb@mail.com", "bbbPass", null)));
				System.out.print("Updating company 2: ");
				adminService.updateCompany(new Company(2, "CCC", "ccc@mail.com", "cccPass", null));
				System.out.println("All companies: " + adminService.getAllCompanies());
				System.out.print("Deleting company 2: ");
				adminService.deleteCompany(2);
				System.out.println("Customer added, id: "
						+ adminService.addCustomer(new Customer(0, "ddd", "DDD", "ddd@mail.com", "dddPass", null)));
				System.out.println("First customer: " + adminService.getOneCustomer(1));
				System.out.println("Customer added, id: "
						+ adminService.addCustomer(new Customer(0, "eee", "EEE", "eee@mail.com", "eeePass", null)));
				System.out.print("Updating customer 2: ");
				adminService.updateCustomer(new Customer(2, "fff", "FFF", "fff@mail.com", "fffPass", null));
				System.out.println("All customers: " + adminService.getAllCustomers());
				System.out.print("Deleting customer 2: ");
				adminService.deleteCustomer(2);
			} else {
				System.out.println("login failed");
			}
		} catch (CouponSystemException e) {
			e.printStackTrace();
		}
		System.out.println("=== testAdmin ended");
	}

	private void testCompany() throws CouponSystemException {
		System.out.println("=== testCompany started");
		CompanyService companyService = (CompanyService) loginManager.login("aaa@mail.com", "aaaPass",
				ClientType.COMPANY);
		if (companyService != null) {
			int max = 11;
			System.out.println("Logged in as company id: " + companyService.getCompanyDetails().getId());
			System.out.println("Coupon added, id: " + companyService.addCoupon(
					new Coupon(0, companyService.getCompanyDetails(), Category.FOOD, "10%", "10% discount on food",
							LocalDate.of(2021, 3, 1), LocalDate.of(2022, 5, 1), 5, 10.9, "image", null)));
			System.out.println("Company coupons up to max " + max + ": " + companyService.getCompanyCoupons(max));
			System.out.println("Coupon added, id: " + companyService.addCoupon(new Coupon(0,
					companyService.getCompanyDetails(), Category.VACATION, "15%", "15% discount on vacation",
					LocalDate.of(2021, 10, 1), LocalDate.of(2022, 3, 1), 10, 22.5, "image", null)));
			System.out.println(
					"Company coupons in category vacation: " + companyService.getCompanyCoupons(Category.VACATION));
			System.out.println("Updating coupon 2: ");
			companyService.updateCoupon(
					new Coupon(2, companyService.getCompanyDetails(), Category.FOOD, "15%", "15% discount on food",
							LocalDate.of(2021, 10, 1), LocalDate.of(2022, 2, 1), 10, 22.5, "image", null));
			System.out.println("Coupon added, id: " + companyService.addCoupon(new Coupon(0,
					companyService.getCompanyDetails(), Category.ELECTRONICS, "5%", "5% discount on electronics",
					LocalDate.of(2021, 10, 1), LocalDate.of(2022, 2, 1), 15, 30, "image", null)));
			System.out.println("All company coupons: " + companyService.getCompanyCoupons());
			System.out.print("Deleting coupon 2: ");
			companyService.deleteCoupon(2);
		} else {
			System.out.println("login failed");
		}
		System.out.println("=== testCompany ended");
	}

	private void testCustomer() throws CouponSystemException {
		System.out.println("=== testCustomer started");
		CustomerService customerService = (CustomerService) loginManager.login("ddd@mail.com", "dddPass",
				ClientType.CUSTOMER);
		if (customerService != null) {
			int max = 20;
			System.out.println("logged in as customer id: " + customerService.getCustomerDetails().getId());
			System.out.print("Purchasing coupon 1: ");
			customerService.purchaseCoupon(
					new Coupon(1, new Company(1, null, null, null, null), Category.FOOD, "10%", "10% discount on food",
							LocalDate.of(2021, 3, 1), LocalDate.of(2022, 5, 1), 5, 10.9, "image", null));
				customerService.purchaseCoupon(new Coupon(3, new Company(1, null, null, null, null), null, null, null,
						null, null, 0, 0, null, null));
			System.out.println("Customer coupons up to max " + max + ": " + customerService.getCustomerCoupons(max));
			System.out.println(
					"Customer coupons in category vacation: " + customerService.getCustomerCoupons(Category.FOOD));
			System.out.println("All company coupons: " + customerService.getCustomerCoupons());
		}
		System.out.println("=== testCustomer ended");
	}
}
