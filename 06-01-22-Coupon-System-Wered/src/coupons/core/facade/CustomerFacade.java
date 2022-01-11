package coupons.core.facade;

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

	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		// check if details match row in table customers
		return false;
	}
	
	public void purchaseCoupon(Coupon coupon) {
		// acquires specific coupon for this client
		// check if coupon already in customers possession (cannot buy same coupon twice)
		// check if any coupons left (if amount is 0, cannot buy this coupon)
		// check coupon endDate (cannot buy coupon if expired)
		// after coupon is purchased, amount--
	}
	
	public ArrayList<Coupon> getCustomerCoupons() {
		// get all coupons for this customer
		return null;
	}
	
	public ArrayList<Coupon> getCustomerCoupons(Category category) {
		// get all coupons for this customer in specific category
		return null;
	}
	
	public ArrayList<Coupon> getCustomerCoupons(double maxPrice) {
		// get all coupons up to maxPrice for this customer
		return null;
	}

	public Customer getCustomerDetails() {
		return null;
	}

	
	
}
