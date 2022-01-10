package coupons.core.main;

import coupons.core.beans.Company;
import coupons.core.dao.CompaniesDAO;
import coupons.core.dao.CompaniesDBDAO;
import coupons.core.dao.ConnectionPool;
import coupons.core.exceptions.CouponSystemException;

public class Test {

	public static void main(String[] args) {
		
		try {
			startSystem();
			Company c = new Company(0, "CCC", "ccc@mail", "cccPass");
			CompaniesDAO dao = new CompaniesDBDAO();
			dao.addCompany(c);
			System.out.println("success");
		} catch (CouponSystemException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			stopSystem();
		}
	}
	
	public static void startSystem() throws CouponSystemException {
		ConnectionPool pool = ConnectionPool.getInstance();
		System.out.println("connection pool up");
	}
	
	public static void stopSystem() {
		
		System.out.println("connection pool down");
	}
	
	public static void testAll() {
		// use daily job thread
		// use LoginManager as Administrator, get AdminFacade and use all methods
		// use LoginManager as Company, get CompanyFacade and use all methods
		// use LoginManager as Customer, get CustomerFacade and use all methods
		// stop daily job thread
		// close all connections (closeAllConnections in ConnectionPool)
		// use one try and catch only
	}

}
