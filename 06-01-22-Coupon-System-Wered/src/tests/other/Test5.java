package tests.other;

import coupons.core.beans.Customer;
import coupons.core.dao.CustomersDAO;
import coupons.core.dao.CustomersDBDAO;
import coupons.core.exceptions.CouponSystemException;

public class Test5 {

	public static void main(String[] args) {

			Customer f = new Customer(0, "fff", "FFF", "fff@mail.com", "fffPass");
			CustomersDAO dao = new CustomersDBDAO();
			try {
				dao.addCustomer(f);
				System.out.println("Success");
			} catch (CouponSystemException e) {
				System.out.println("Error: " + e.getMessage());
			}
	}
}
