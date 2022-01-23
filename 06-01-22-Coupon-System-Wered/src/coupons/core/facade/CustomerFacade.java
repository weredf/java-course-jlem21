package coupons.core.facade;

import java.time.LocalDate;
import java.util.ArrayList;

import coupons.core.beans.Category;
import coupons.core.beans.Coupon;
import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;

public class CustomerFacade extends ClientFacade {

	private int customerId; // equals id entered through login

	public CustomerFacade(int customerId) {
		super();
		this.customerId = customerId;
	}

	public CustomerFacade() {
	}

	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		if(customersDAO.isCustomerExists(email, password)) {
			this.customerId = customersDAO.getOneCustomer(email, password).getId();
			return true;
		}
		return false;
	}
	
	/**
	 * Purchase coupon by customer after checking exists
	 * @param coupon
	 * @throws CouponSystemException
	 */
	public void purchaseCoupon(Coupon coupon) throws CouponSystemException {
		// check if coupon already in customers possession
		if (!couponsDAO.isCouponPurchaseExists(customerId, coupon.getId())) {
			// check if any coupons left (if amount is 0, cannot buy this coupon)
			if (coupon.getAmount() > 0) {
				// check coupon endDate (cannot buy coupon if expired)
				LocalDate endDate = coupon.getEndDate();
				LocalDate now = LocalDate.now();
				if (now.isBefore(endDate)) {
					// purchase coupon for this client
					couponsDAO.addCouponPurchase(customerId, coupon.getId());
					// after coupon is purchased, amount--
					int amount = coupon.getAmount();
					coupon.setAmount(amount--);
				} else {
					throw new CouponSystemException("purchaseCoupon " + coupon + " failed - coupon expired");
				}
			} else {
				throw new CouponSystemException("purchaseCoupon " + coupon + " failed - no coupons left");
			}
		} else {
			throw new CouponSystemException("purchaseCoupon " + coupon + " failed - can't buy same coupon twice");
		}
	}
	
	/**
	 * Get all coupons for one customer
	 * @return ArrayList
	 * @throws CouponSystemException
	 */
	public ArrayList<Coupon> getCustomerCoupons() throws CouponSystemException {
		return couponsDAO.getAllCouponsForCustomer(customerId);
	}
	
	/**
	 * Get all coupons for one customer in one category
	 * @param category
	 * @return ArrayList
	 * @throws CouponSystemException
	 */
	public ArrayList<Coupon> getCustomerCoupons(Category category) throws CouponSystemException {
		return couponsDAO.getAllCouponsInCategoryForCustomer(customerId, category);
	}
	
	/**
	 * Get all coupons for one customer up to max price
	 * @param maxPrice
	 * @return ArrayList
	 * @throws CouponSystemException
	 */
	public ArrayList<Coupon> getCustomerCoupons(double maxPrice) throws CouponSystemException {
		return couponsDAO.getAllCouponsForCustomerMax(customerId, maxPrice);
	}

	/**
	 * Get one customer from customers database
	 * @return ArrayList
	 * @throws CouponSystemException
	 */
	public Customer getCustomerDetails() throws CouponSystemException {
		return customersDAO.getOneCustomer(customerId);
	}

}
