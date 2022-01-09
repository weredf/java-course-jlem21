package coupons.core.dao;

import coupons.core.beans.Company;
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

}
