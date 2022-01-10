package coupons.core.facade;

import java.util.ArrayList;

import coupons.core.beans.Category;
import coupons.core.beans.Company;
import coupons.core.beans.Coupon;
import coupons.core.exceptions.CouponSystemException;

public class CompanyFacade extends ClientFacade {

	private int companyId; // equals id entered through login

	public CompanyFacade(int companyId) {
		super();
		this.companyId = companyId;
	}

	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		// check if details match row in table companies
		return super.login(email, password);
	}

	public void addCoupon(Coupon coupon) {
		// check if coupon title doesn't already exist for this company
		// check if values are right?
		// add coupon
	}
	
	public void updateCoupon(Coupon coupon) {
		// check if coupon exists
		// check if values are right? Cannot update couponId or companyId
		// update coupon
	}
	
	public void deleteCoupon(int couponId) {
		// check if coupon exists
		// delete coupon
		// delete all coupon purchases by customers
	}
	
	public ArrayList<Coupon> getCompanyCoupons() {
		// get all coupons for this company
		return null;
	}
	
	public ArrayList<Coupon> getCompanyCoupons(Category category) {
		// get all coupons for this company in specific category
		return null;
	}
	
	public ArrayList<Coupon> getCompanyCoupons(double maxPrice) {
		// get all coupons up to maxPrice for this company
		return null;
	}

	public Company getCompanyDetails() {
		return null;
	}
	
	
}
