package coupons.core.dao;

import java.util.ArrayList;

import coupons.core.beans.Coupon;

public interface CouponsDAO {

	public void addCoupon(Coupon coupon) {
		
	}
	
	public void updateCompany(Company company) {
		
	}
	
	public void deleteCoupon(int couponId) {
		
	}
	
	public ArrayList<Coupon> getAllCoupons() {
		return null;
	}
	
	public Coupon getOneCoupon(int couponId) {
		return null;
	}
	
	public void addCouponPurchase(int customerId, int couponId) {
		
	}
	
	public void deleteCouponPurchase(int customerId, int couponId) {
		
	}
}
