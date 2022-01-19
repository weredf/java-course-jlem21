package tests;

import coupons.core.beans.Company;
import coupons.core.dao.CompaniesDAO;
import coupons.core.dao.CompaniesDBDAO;
import coupons.core.dao.ConnectionPool;
import coupons.core.exceptions.CouponSystemException;

public class Test2 {

	public static void main(String[] args) {

		try {
			Company c = new Company(0, "BBB", "bbb@mail.com", "bbbPass");
			CompaniesDAO dao = new CompaniesDBDAO();
			int id = dao.addCompany(c);
			System.out.println("created company: " + id);
			System.out.println(c);
		} catch (CouponSystemException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				ConnectionPool.getInstance().closeAllConnections();
				System.out.println("All connections closed");
			} catch (CouponSystemException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

}
