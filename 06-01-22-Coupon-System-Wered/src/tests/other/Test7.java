package tests.other;

import coupons.core.dao.CouponsDAO;
import coupons.core.dao.CouponsDBDAO;
import coupons.core.exceptions.CouponSystemException;

public class Test7 {

	public static void main(String[] args) {

			CouponsDAO dao2 = new CouponsDBDAO();
			try {
				dao2.addCouponPurchase(1, 1);
				dao2.addCouponPurchase(1, 2);
				dao2.deleteCouponPurchase(1, 1);
			} catch (CouponSystemException e) {
				System.out.println("Error: " + e.getMessage());
			}
			System.out.println("Success");
	}
}
