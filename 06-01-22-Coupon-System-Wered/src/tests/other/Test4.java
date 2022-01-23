package tests.other;

import coupons.core.beans.Company;
import coupons.core.dao.CompaniesDAO;
import coupons.core.dao.CompaniesDBDAO;
import coupons.core.exceptions.CouponSystemException;

public class Test4 {

	public static void main(String[] args) {

			Company c = new Company(0, "DDD", "ddd@mail.com", "dddPass");
			CompaniesDAO dao = new CompaniesDBDAO();
			try {
				dao.addCompany(c);
			} catch (CouponSystemException e) {
				System.out.println("Error: " + e.getMessage());
			}
			System.out.println("Success");
	}
}
