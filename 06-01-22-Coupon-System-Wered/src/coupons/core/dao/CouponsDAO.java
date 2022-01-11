package coupons.core.dao;

import java.util.ArrayList;

import coupons.core.beans.Coupon;
import coupons.core.exceptions.CouponSystemException;

public interface CouponsDAO {

	/**
	 * Add a coupon to the coupons database
	 * @param coupon
	 * @return automatically generated coupon id from database of coupon created
	 * @throws CouponSystemException
	 */
	int addCoupon(Coupon coupon) throws CouponSystemException;
	
	/**
	 * Update one coupon in coupons database
	 * @param coupon
	 * @throws CouponSystemException
	 */
	void updateCoupon(Coupon coupon) throws CouponSystemException;
	
	/**
	 * Delete coupon from coupons database
	 * @param couponId
	 * @throws CouponSystemException
	 */
	void deleteCoupon(int couponId) throws CouponSystemException;
	
	/**
	 * Get all coupons from coupons database
	 * @return ArrayList<Coupon>
	 * @throws CouponSystemException
	 */
	ArrayList<Coupon> getAllCoupons() throws CouponSystemException;
	
	/**
	 * Get one coupon from coupons database
	 * @param couponId
	 * @return Coupon
	 * @throws CouponSystemException
	 */
	Coupon getOneCoupon(int couponId) throws CouponSystemException;
	
	/**
	 * Add a purchased coupon in customers_vs_coupons database
	 * @param customerId
	 * @param couponId
	 * @throws CouponSystemException
	 */
	void addCouponPurchase(int customerId, int couponId) throws CouponSystemException;
	
	/**
	 * Delete a purchased coupon from customers_vs_coupons database
	 * @param customerId
	 * @param couponId
	 * @throws CouponSystemException
	 */
	void deleteCouponPurchase(int customerId, int couponId) throws CouponSystemException;
}
