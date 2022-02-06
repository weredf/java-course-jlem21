package app.core.tests;

import java.time.LocalDate;
import java.util.ArrayList;

import app.core.entities.Category;
import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.repos.CouponRepo;
import app.core.exceptions.CouponSystemException;
import app.core.services.AdminService;
import app.core.services.CompanyService;
import app.core.services.CustomerService;
import app.core.job.CouponExpirationDailyJob;
import app.core.login.ClientType;
import app.core.login.LoginManager;

public class Test {

	private static Test instance = new Test();

	public static Test getInstance() {
		return instance;
	}
	
	public static void testAll() throws CouponSystemException {
		System.out.println("--- testAll started");
		CouponExpirationDailyJob job = null;
		try {
			CouponRepo couponRepo = new CouponRepo();
			job = new CouponExpirationDailyJob(couponRepo);
			job.startDailyJob();
			LoginManager manager = LoginManager.getInstance();
			testAdmin(manager);
			testCompany(manager);
			testCustomer(manager);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();

		} finally {
			System.out.println("stop thread in 5 seconds");
			try {
				Thread.sleep(5000);
				job.stopDailyJob();
				job.getThread().join();

			} catch (InterruptedException e) {
				throw new CouponSystemException("Interrupted ", e);
			}

		}
		System.out.println("testAll End ========");

	}

	private static void testAdmin(LoginManager manager) throws CouponSystemException {
		System.out.println("--- testAdmin started");
		AdminService adminService = (AdminService) manager.login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
		Company company = new Company(0, "hhh", "hhh@mail.com", "hhhPass");
		Company c = new Company(0, "BBB", "bbb@mail.com", "bbbPass");
		company.setId(adminService.addCompany(company));
		System.out.println("company added: " + company.toString());
		System.out.println("get company: " + adminService.getOneCompany(company.getId()));
		c.setId(adminService.addCompany(c));
		System.out.println("company added: "+ c.toString());
		adminService.deleteCompany(c.getId());
		System.out.println("company " + c.getId() + " deleted");
		Company update = new Company(company.getId(), "hhh", "HHH@mail.com", "HHHPASS");
		adminService.updateCompany(update);
		System.out.println("company " + update.getId() + " updated");
		ArrayList<Company> companies = new ArrayList<>(adminService.getAllCompanies());
		System.out.println("All companies: " + companies.toString());
		Customer customer = new Customer(0, "jjj", "JJJ", "jjj@mail.com", "jjjPass");
		Customer cr = new Customer(0, "fff", "FFF", "fff@mail.com", "fffPass");
		customer.setId(adminService.addCustomer(customer));
		System.out.println("customer added: " + customer.toString());
		System.out.println("get company: " + adminService.getOneCustomer(customer.getId()));
		cr.setId(adminService.addCustomer(cr));
		System.out.println("customer added: " + cr.toString());
		adminService.deleteCustomer(cr.getId());
		System.out.println("customer " + cr.getId() + " deleted");
		Customer update2 = new Customer(customer.getId(), "JJJ", "jjj", "jjj@mail.com", "JJJPASS");
		adminService.updateCustomer(update2);
		System.out.println("customer "+ update2.getId() + " updated");
		ArrayList<Customer> customers = new ArrayList<>(adminService.getAllCustomers());
		System.out.println("All customers: " + customers.toString());
		System.out.println("testAdmin End ========");
	}

	private static void testCompany(LoginManager manager) throws CouponSystemException {
		System.out.println("--- testCompany started");
		CompanyService companyService = (CompanyService) manager.login("HHH@mail.com", "HHHPASS", ClientType.COMPANY);
		if (companyService != null) {
			System.out.println("Company login success");
			Coupon coupon = new Coupon(0, companyService.getCompanyId(), Category.RESTAURANT, "15%discount",
					"15% discount on all dishes", LocalDate.of(2022, 1, 21), LocalDate.of(2022, 5, 19), 10, 12.50,
					"image3");
			Coupon c = new Coupon(0, companyService.getCompanyId(), Category.ELECTRONICS, "10%discount", "10% discount on all electronics",
					LocalDate.of(2021, 10, 22), LocalDate.of(2022, 1, 20), 10, 21.50, "image4");
			coupon.setId(companyService.addCoupon(coupon));
			System.out.println("coupon added: " + coupon.toString());
			c.setId(companyService.addCoupon(c));
			System.out.println("coupon added: " + c.toString());
			Coupon update = new Coupon(coupon.getId(), companyService.getCompanyId(), Category.VACATION, "20%discount", "20% discount on one vacation", LocalDate.of(2021, 8, 16), LocalDate.of(2022, 8, 16), 5, 18.90, "image4");
			companyService.updateCoupon(update);
			System.out.println("coupon "+ update.getId() + " updated");
			ArrayList<Coupon> coupons = new ArrayList<>(companyService.getCompanyCoupons());
			System.out.println("All coupons for company: " + coupons.toString());
			ArrayList<Coupon> coupons2 = new ArrayList<>(companyService.getCompanyCoupons(Category.VACATION));
			System.out.println("All coupons in category " + Category.VACATION.toString() + " for company: " + coupons2.toString());
			final int MAX = 25;
			ArrayList<Coupon> coupons3 = new ArrayList<>(companyService.getCompanyCoupons(MAX));
			System.out.println("All coupons for company " + companyService.getCompanyId() + " up to max " + MAX + ": " + coupons3.toString());
			System.out.println("Get company details: " + companyService.getCompanyDetails().toString());
			companyService.deleteCoupon(c.getId());
			System.out.println("coupon " + c.getId() + " deleted");
		} else {
			System.out.println("Company login failed");
		}
		System.out.println("testCompany End ========");
	}

	private static void testCustomer(LoginManager manager) throws CouponSystemException {
		System.out.println("--- testCustomer started");
		CustomerService customerService1 = (CustomerService) manager.login("fff@mail.com", "fffPass", ClientType.CUSTOMER);
		if (customerService1 == null) {
			System.out.println("Customer login failed");
		}
		CustomerService customerService2 = (CustomerService) manager.login("jjj@mail.com", "JJJPASS", ClientType.CUSTOMER);
		if (customerService2 != null) {
			System.out.println("Customer login success");
			CouponRepo DAO = new CouponRepo();
			Coupon coupon = DAO.getOneCoupon(1);
			customerService2.purchaseCoupon(coupon);
			System.out.println("coupon purchased: " + coupon.toString());
			ArrayList<Coupon> cc = new ArrayList<>(customerService2.getCustomerCoupons());
			System.out.println("All customer coupons: " + cc.toString());
			ArrayList<Coupon> cc2 = new ArrayList<>(customerService2.getCustomerCoupons(Category.VACATION));
			System.out.println("All customer coupons in category " + Category.VACATION.toString() + ": " + cc2.toString());
			final int MAX = 25;
			ArrayList<Coupon> cc3 = new ArrayList<>(customerService2.getCustomerCoupons(MAX));
			System.out.println("All coupons for customer " + customerService2.getCustomerId() + " up to max " + MAX + ": " + cc3.toString());
			System.out.println(customerService2.getCustomerDetails().toString());
		} else {
			System.out.println("Customer login failed");

		}
		System.out.println("testCustomer End ========");
	}

}