package tests.other;

import coupons.core.beans.Company;
import coupons.core.dao.CompaniesDAO;
import coupons.core.dao.CompaniesDBDAO;
import coupons.core.dao.ConnectionPool;
import coupons.core.exceptions.CouponSystemException;

public class Test3 {

	public static void main(String[] args) {
		try {
			startSystem();
			Company c = new Company(0, "CCC", "ccc@mail.com", "cccPass");
			CompaniesDAO dao = new CompaniesDBDAO();
			dao.addCompany(c);
			System.out.println("success");
		} catch (CouponSystemException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				stopSystem();
			} catch (CouponSystemException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
	
	public static void startSystem() throws CouponSystemException {
		ConnectionPool pool = ConnectionPool.getInstance();
		System.out.println("connection pool up");
	}
	
	public static void stopSystem() throws CouponSystemException {
		ConnectionPool pool = ConnectionPool.getInstance();
		System.out.println("connection pool down");
	}

}
