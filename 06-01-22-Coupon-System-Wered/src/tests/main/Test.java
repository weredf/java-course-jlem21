package tests.main;

import java.time.LocalDate;
import java.util.ArrayList;

import coupons.core.beans.Category;
import coupons.core.beans.Company;
import coupons.core.beans.Coupon;
import coupons.core.beans.Customer;
import coupons.core.dao.ConnectionPool;
import coupons.core.dao.CouponsDAO;
import coupons.core.dao.CouponsDBDAO;
import coupons.core.exceptions.CouponSystemException;
import coupons.core.facade.AdminFacade;
import coupons.core.facade.CompanyFacade;
import coupons.core.facade.CustomerFacade;
import coupons.core.job.CouponExpirationDailyJob;
import coupons.core.login.ClientType;
import coupons.core.login.LoginManager;

public class Test {

	
	public static void testAll() throws CouponSystemException {
		CouponExpirationDailyJob job = null;
		try {
			CouponsDAO DAO = new CouponsDBDAO();
			job = new CouponExpirationDailyJob(DAO);
			job.startDailyJob();
			LoginManager manager = LoginManager.getInstance();
			testAdmin(manager);
			testCompany(manager);
			testCustomer(manager);
		} catch (Exception e) {
			throw new CouponSystemException("testAll failed - ", e);
		}finally {
			System.out.println("stop thread in 5 seconds");
			try {
				Thread.sleep(5000);
				job.stopDailyJob();
				job.getThread().join();
				
				ConnectionPool.getInstance().closeAllConnections();
			} catch (InterruptedException e) {
				throw new CouponSystemException("Interrupted ", e);
			}
			
		}
		System.out.println("testAll End ========");
		
	}

	private static void testAdmin(LoginManager manager) throws CouponSystemException {
		System.out.println("testAdmin started");
		AdminFacade adminFacade = (AdminFacade) manager.login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
		Company company = new Company(0, "hhh", "hhh@mail.com", "hhhPass");
		Company c = new Company(0, "BBB", "bbb@mail.com", "bbbPass");
		System.out.println(company.toString());
		adminFacade.addCompany(company);
		System.out.println("company added " + company.toString());
		adminFacade.addCompany(c);
		System.out.println("company added " + c.toString());
//		Company update = new Company(0, "hhh", "HHH@mail.com", "HHHPASS");
//		adminFacade.updateCompany(update);
//		System.out.println("company " + update.getId() + " updated");
		System.out.println(adminFacade.getOneCompany(1));
		adminFacade.deleteCompany(1);
		System.out.println("company " + company.getId() + " deleted");
		ArrayList<Company> companies = new ArrayList<>(adminFacade.getAllCompanies());
		System.out.println("All companies: " + companies.toString());
		Customer customer = new Customer(0, "jjj", "JJJ", "jjj@mail.com", "jjjPass");
		Customer cr = new Customer(0, "fff", "FFF", "fff@mail.com", "fffPass");
		System.out.println(customer.toString());
		adminFacade.addCustomer(customer);
		System.out.println(cr.toString());
		adminFacade.addCustomer(cr);
		System.out.println("customer added " + customer);
//		Customer update2 = new Customer(1, "JJJ", "jjj", "jjj@mail.com", "JJJPASS");
//		adminFacade.updateCustomer(update2);
//		System.out.println("customer "+ update2.getId() + " updated");
		System.out.println(adminFacade.getOneCustomer(1));
		ArrayList<Customer> customers = new ArrayList<>(adminFacade.getAllCustomers());
		System.out.println("All customers: " + customers.toString());
		adminFacade.deleteCustomer(1);
		System.out.println("customer " + customer.getId() + " deleted");
		System.out.println("testAdmin End ========");
	}
	
	private static void testCompany(LoginManager manager) throws CouponSystemException {
		System.out.println("testCompany started");
		CompanyFacade companyFacade = (CompanyFacade) manager.login("bbb@mail.com", "bbbPass", ClientType.COMPANY);
		Coupon coupon = new Coupon(0, companyFacade.getCompanyId(), Category.RESTAURANT, "15%discount", "15% discount on all dishes", LocalDate.of(2021, 10, 21), LocalDate.of(2022, 1, 19), 10, 12.50, "image3");
		System.out.println(coupon.toString());
		companyFacade.addCoupon(coupon);
		System.out.println("coupon added " + coupon);
//		Coupon update = new Coupon(coupon.getId(), companyFacade.getCompanyId(), Category.VACATION, "20%discount", "20% discount on one vacation", LocalDate.of(2021, 8, 16), LocalDate.of(2021, 12, 16), 5, 18.90, "image4");
//		companyFacade.updateCoupon(update);
		ArrayList<Coupon> coupons = new ArrayList<>(companyFacade.getCompanyCoupons());
		System.out.println("All coupons: " + coupons.toString());
		ArrayList<Coupon> coupons2 = new ArrayList<>(companyFacade.getCompanyCoupons(Category.VACATION));
		System.out.println("All coupons in category " + Category.VACATION.toString() + ": " + coupons2.toString());
		ArrayList<Coupon> coupons3 = new ArrayList<>(companyFacade.getCompanyCoupons(2));
		System.out.println("All coupons for company " + companyFacade.getCompanyId() + ": " + coupons3.toString());
		System.out.println(companyFacade.getCompanyDetails().toString());
		companyFacade.deleteCoupon(coupon.getId());
		System.out.println("testCompany End ========");
	}

	private static void testCustomer(LoginManager manager) throws CouponSystemException {
		CustomerFacade customerFacade = (CustomerFacade) manager.login("fff@mail.com", "fffPass", ClientType.CUSTOMER);
		Coupon coupon = new Coupon(0, 1, Category.ELECTRONICS, "10%discount", "10% discount on all electronics", LocalDate.of(2021, 10, 22), LocalDate.of(2022, 2, 20), 10, 21.50, "image4");
		customerFacade.purchaseCoupon(coupon);
		System.out.println(coupon.toString());
		ArrayList<Coupon> cc = new ArrayList<>(customerFacade.getCustomerCoupons());
		System.out.println(cc.toString());
		ArrayList<Coupon> cc2 = new ArrayList<>(customerFacade.getCustomerCoupons(Category.ELECTRONICS));
		System.out.println(cc2.toString());
		ArrayList<Coupon> cc3 = new ArrayList<>(customerFacade.getCustomerCoupons(25));
		System.out.println(cc3.toString());
		System.out.println(customerFacade.getCustomerDetails().toString());
	}
}