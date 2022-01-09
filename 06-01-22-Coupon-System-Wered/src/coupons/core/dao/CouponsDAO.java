package coupons.core.dao;

import java.util.ArrayList;

import coupons.core.beans.Coupon;
import coupons.core.exceptions.CouponSystemException;

public interface CouponsDAO {

	int addCoupon(Coupon coupon) throws CouponSystemException;
	
	void updateCoupon(Coupon coupon) throws CouponSystemException;
	
	void deleteCoupon(int couponId) throws CouponSystemException;
	
	ArrayList<Coupon> getAllCoupons() throws CouponSystemException;
	
	Coupon getOneCoupon(int couponId) throws CouponSystemException;
	
	void addCouponPurchase(int customerId, int couponId) throws CouponSystemException;
	
	void deleteCouponPurchase(int customerId, int couponId) throws CouponSystemException;
}
