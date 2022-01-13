package coupons.core.dao;

import java.util.ArrayList;

import coupons.core.beans.Category;
import coupons.core.beans.Coupon;
import coupons.core.exceptions.CouponSystemException;

public interface CouponsDAO {

	/**
	 * Check if coupon title is used for this company
	 * @param companyId
	 * @param title
	 * @return boolean
	 * @throws CouponSystemException
	 */
	boolean isCouponExists(int companyId, String title) throws CouponSystemException;
	
	/**
	 * Check if coupon exists
	 * @param id
	 * @return boolean
	 * @throws CouponSystemException
	 */
	boolean isCouponExists(int id) throws CouponSystemException;

	/**
	 * Check if coupon purchase exists
	 * @param couponId
	 * @return boolean
	 * @throws CouponSystemException
	 */
	boolean isCouponPurchaseExists(int couponId) throws CouponSystemException;

	/**
	 * Check if coupon purchase exists for one customer
	 * @param customerId
	 * @param id
	 * @return boolean
	 * @throws CouponSystemException
	 */
	boolean isCouponPurchaseExists(int customerId, int couponId) throws CouponSystemException;

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
	 * Get all coupons for one company
	 * @param companyId
	 * @return ArrayList<Coupon>
	 * @throws CouponSystemException
	 */
	ArrayList<Coupon> getAllCouponsForCompany(int companyId) throws CouponSystemException;

	/**
	 * Get all coupons for one company in one category
	 * @param companyId
	 * @return ArrayList<Coupon>
	 * @throws CouponSystemException
	 */
	ArrayList<Coupon> getAllCouponsInCategoryForCompany(int companyId, Category category) throws CouponSystemException;

	/**
	 * Get all coupons for one company up to max price
	 * @param companyId
	 * @param maxPrice
	 * @return ArrayList<Coupon>
	 * @throws CouponSystemException
	 */
	ArrayList<Coupon> getAllCouponsForCompanyMax(int companyId, double maxPrice) throws CouponSystemException;

	/**
	 * Get all coupons for one customer
	 * @param customerId
	 * @return ArrayList<Coupon>
	 * @throws CouponSystemException
	 */
	ArrayList<Coupon> getAllCouponsForCustomer(int customerId) throws CouponSystemException;

	/**
	 * Get all coupons for one customer in one category
	 * @param customerId
	 * @param category
	 * @return ArrayList<Coupon>
	 * @throws CouponSystemException
	 */
	ArrayList<Coupon> getAllCouponsInCategoryForCustomer(int customerId, Category category) throws CouponSystemException;

	/**
	 * Get all coupons for once customer up to max price
	 * @param customerId
	 * @param maxPrice
	 * @return ArrayList<Coupon>
	 * @throws CouponSystemException
	 */
	ArrayList<Coupon> getAllCouponsForCustomerMax(int customerId, double maxPrice) throws CouponSystemException;

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

	/**
	 * Delete a purchased coupon from customers_vs_coupons database for all customers
	 * @param couponId
	 * @throws CouponSystemException
	 */
	void deleteCouponPurchase(int couponId) throws CouponSystemException;

}
