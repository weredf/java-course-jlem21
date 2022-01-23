package tests.main;

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
		// everything in try catch
		// activate daily job
		// log in through LoginManager as Administrator, get AdminFacade, use all methods
		// log in through LoginManager as Company, get CompanyFacade, use all methods
		// log in through LoginManager as Customer, get CustomerFacade, use all methods
		// end daily job
		// close all connections
		try {
			CouponsDAO DAO = new CouponsDBDAO();
			CouponExpirationDailyJob job = new CouponExpirationDailyJob(DAO);
			job.startDailyJob();
			job.run();
			/*
			LoginManager manager = LoginManager.getInstance();
			AdminFacade adminFacade = (AdminFacade) manager.login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
			adminFacade.addCompany(null);
			adminFacade.updateCompany(null);
			adminFacade.deleteCompany(0);
			adminFacade.getAllCompanies();
			adminFacade.getOneCompany(0);
			adminFacade.addCustomer(null);
			adminFacade.updateCustomer(null);
			adminFacade.deleteCustomer(0);
			adminFacade.getAllCustomers();
			adminFacade.getOneCustomer(0);
			
			CompanyFacade companyFacade = (CompanyFacade) manager.login("bbb@mail.com", "bbbPass", ClientType.COMPANY);
			companyFacade.addCoupon(null);
			companyFacade.updateCoupon(null);
			companyFacade.deleteCoupon(0);
			companyFacade.getCompanyCoupons();
			companyFacade.getCompanyCoupons(null);
			companyFacade.getCompanyCoupons(0);
			companyFacade.getCompanyDetails();
			
			CustomerFacade customerFacade = (CustomerFacade) manager.login("fff@mail.com", "fffPass", ClientType.CUSTOMER);
			customerFacade.purchaseCoupon(null);
			customerFacade.getCustomerCoupons();
			customerFacade.getCustomerCoupons(null);
			customerFacade.getCustomerCoupons(0);
			customerFacade.getCustomerDetails();
			*/
			job.wait(5000);
			job.stopDailyJob();
			
			ConnectionPool.getInstance().closeAllConnections();
		} catch (Exception e) {
			throw new CouponSystemException("TestAll failed - ", e);
		}
	}
}
