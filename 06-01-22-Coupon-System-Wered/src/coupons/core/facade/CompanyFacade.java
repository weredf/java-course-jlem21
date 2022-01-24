package coupons.core.facade;

import java.util.ArrayList;

import coupons.core.beans.Category;
import coupons.core.beans.Company;
import coupons.core.beans.Coupon;
import coupons.core.exceptions.CouponSystemException;

public class CompanyFacade extends ClientFacade {

	private int companyId;

	public int getCompanyId() {
		return companyId;
	}

	public CompanyFacade() {
	}
	
	public CompanyFacade(int companyId) {
		super();
		this.companyId = companyId;
	}

	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		if(companiesDAO.isCompanyExists(email, password)) {
			this.companyId = companiesDAO.getOneCompany(email, password).getId();
			return true;
		}
		return false;
	}

	/**
	 * Add coupon after checking values and exists
	 * @param coupon
	 * @throws CouponSystemException
	 */
	public int addCoupon(Coupon coupon) throws CouponSystemException {
		// check if input is valid
		if (coupon.getCompany() != 0 && coupon.getCategory() != null && coupon.getTitle() != null
				&& coupon.getDescription() != null && coupon.getStartDate() != null && coupon.getEndDate() != null
				&& coupon.getAmount() != 0 && coupon.getPrice() != 0 && coupon.getImage() != null) {
			// check if coupon title doesn't already exist for this company
			if (!couponsDAO.isCouponExists(companyId, coupon.getTitle())) {
				// add coupon
				int id = couponsDAO.addCoupon(coupon);
				return id;
			} else {
				throw new CouponSystemException(
						"addCoupon " + coupon + " failed - coupon title " + coupon.getTitle() + " already exists");
			}
		} else {
			throw new CouponSystemException("addCoupon " + coupon + " failed - input not valid");
		}
	}

	/**
	 * Update coupon after checking values and exists
	 * @param coupon
	 * @throws CouponSystemException
	 */
	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		// check if input is valid
		if (coupon.getId() != 0 && coupon.getCompany() != 0 && coupon.getCategory() != null && coupon.getTitle() != null && coupon.getDescription() != null
				&& coupon.getStartDate() != null && coupon.getEndDate() != null && coupon.getAmount() != 0
				&& coupon.getPrice() != 0 && coupon.getImage() != null) {
			// check if coupon exists
			if (couponsDAO.isCouponExists(coupon.getId(), getCompanyId())) {
				// update coupon
				couponsDAO.updateCoupon(coupon);
			} else {
				throw new CouponSystemException("updateCoupon " + coupon + " failed - coupon doesn't exist");
			}
		} else {
			throw new CouponSystemException("updateCoupon " + coupon + " failed - input not valid");
		}
	}

	/**
	 * Delete coupon after checking exists
	 * @param couponId
	 * @throws CouponSystemException
	 */
	public void deleteCoupon(int couponId) throws CouponSystemException {
		// check if coupon exists (double check if belongs to companyId?)
		if (couponsDAO.isCouponExists(couponId)) {
			// check if coupon purchases by customers exist
			if (couponsDAO.isCouponPurchaseExists(couponId)) {
				// delete all coupon purchases by customers
				couponsDAO.deleteCouponPurchase(couponId);
				// delete coupon
				couponsDAO.deleteCoupon(couponId);
			} else {
				couponsDAO.deleteCoupon(couponId);
			}
		} else {
			throw new CouponSystemException("deleteCoupon " + couponId + " failed - coupon doesn't exist");
		}
	}

	/**
	 * Get all coupons for one company 
	 * @return ArrayList
	 * @throws CouponSystemException
	 */
	public ArrayList<Coupon> getCompanyCoupons() throws CouponSystemException {
		return couponsDAO.getAllCouponsForCompany(companyId);
	}

	/**
	 * Get all coupons for one company in one category
	 * @param category
	 * @return ArrayList
	 * @throws CouponSystemException
	 */
	public ArrayList<Coupon> getCompanyCoupons(Category category) throws CouponSystemException {
		return couponsDAO.getAllCouponsInCategoryForCompany(companyId, category);
	}

	/**
	 * Get all coupons for one company up to max price
	 * @param maxPrice
	 * @return ArrayList
	 * @throws CouponSystemException
	 */
	public ArrayList<Coupon> getCompanyCoupons(double maxPrice) throws CouponSystemException {
		return couponsDAO.getAllCouponsForCompanyMax(companyId, maxPrice);
	}

	/**
	 * Get one company from companies database
	 * @return Company
	 * @throws CouponSystemException
	 */
	public Company getCompanyDetails() throws CouponSystemException {
		return companiesDAO.getOneCompany(companyId);
	}

}
