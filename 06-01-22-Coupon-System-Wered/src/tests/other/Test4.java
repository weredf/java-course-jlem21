package tests.other;

import coupons.core.beans.Company;
import coupons.core.dao.CompaniesDAO;
import coupons.core.dao.CompaniesDBDAO;
import coupons.core.exceptions.CouponSystemException;

public class Test4 {

	public static void main(String[] args) {

			Company c1 = new Company(0, "DDD", "ddd@mail.com", "dddPass");
			CompaniesDAO dao = new CompaniesDBDAO();
			try {
				dao.addCompany(c1);
				Company c2 = new Company(c1.getId(), "DDD", "DDD@mail.com", "DDDPASS");
				dao.updateCompany(c2);
				System.out.println("Success");
			} catch (CouponSystemException e) {
				System.out.println("Error: " + e.getMessage());
			}
	}
}
