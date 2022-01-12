package coupons.core.facade;

import java.time.LocalDate;
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
		// check if details match row in table companies?
		return true;
	}

	public void addCoupon(Coupon coupon) throws CouponSystemException {
		// check if input is valid
		if (coupon.getCompany() != 0 && coupon.getCategory() != null && coupon.getTitle() != null
				&& coupon.getDescription() != null && coupon.getStartDate() != null && coupon.getEndDate() != null
				&& coupon.getAmount() != 0 && coupon.getPrice() != 0 && coupon.getImage() != null) {
			// check if coupon title doesn't already exist for this company
			if (!couponsDAO.isCouponExists(companyId, coupon.getTitle())) {
				// add coupon
				couponsDAO.addCoupon(coupon);
			}
		}
	}

	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		
		// check if coupon exists
		if (couponsDAO.isCouponExists(coupon.getId())) {
			
		}
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
