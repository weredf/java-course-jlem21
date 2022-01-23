package tests.other;

import java.time.LocalDate;

import coupons.core.beans.Category;
import coupons.core.beans.Coupon;
import coupons.core.dao.CouponsDAO;
import coupons.core.dao.CouponsDBDAO;
import coupons.core.exceptions.CouponSystemException;

public class Test6 {

	public static void main(String[] args) {

			Coupon c1 = new Coupon(0, 1, Category.FOOD, "20%discount", "20% discount on all food", LocalDate.of(2020, 11, 22), LocalDate.of(2022, 1, 22), 5, 15.95, "image1");
			Coupon c2 = new Coupon(0, 1, Category.FOOD, "10%discount", "10% discount on all food", LocalDate.of(2021, 1, 24), LocalDate.of(2022, 6, 24), 5, 10.95, "image2");
			CouponsDAO dao = new CouponsDBDAO();
			try {
				dao.addCoupon(c1);
				dao.addCoupon(c2);
			} catch (CouponSystemException e) {
				System.out.println("Error: " + e.getMessage());
			}
			System.out.println("Success");
	}
}
