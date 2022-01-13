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
			} else {
				throw new CouponSystemException(
						"addCoupon " + coupon + " failed - coupon title " + coupon.getTitle() + " already exists");
			}
		} else {
			throw new CouponSystemException("addCoupon " + coupon + " failed - input not valid");
		}
	}

	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		// check if input is valid
		if (coupon.getId() != 0 && coupon.getCompany() != 0) {
			// check if coupon exists
			if (couponsDAO.isCouponExists(coupon.getId())) {
				// check if input matches - cannot update couponId or companyId
				Coupon c = couponsDAO.getOneCoupon(coupon.getId());
				if (c.getCompany() == coupon.getCompany() && c.getCompany() == companyId) {
					// check if update input is valid
					if (coupon.getCategory() != null && coupon.getTitle() != null && coupon.getDescription() != null
							&& coupon.getStartDate() != null && coupon.getEndDate() != null && coupon.getAmount() != 0
							&& coupon.getPrice() != 0 && coupon.getImage() != null) {
						// update coupon
						couponsDAO.updateCoupon(coupon);
					} else {
						throw new CouponSystemException("updateCoupon " + coupon + " failed - update input not valid");
					}
				} else {
					throw new CouponSystemException("updateCoupon " + coupon + " failed - can't update id values");
				}
			} else {
				throw new CouponSystemException("updateCoupon " + coupon + " failed - coupon doesn't exist");
			}
		} else {
			throw new CouponSystemException("updateCoupon " + coupon + " failed - search input not valid");
		}
	}

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

	public ArrayList<Coupon> getCompanyCoupons() throws CouponSystemException {
		return couponsDAO.getAllCouponsForCompany(companyId);
	}

	public ArrayList<Coupon> getCompanyCoupons(Category category) throws CouponSystemException {
		return couponsDAO.getAllCouponsInCategoryForCompany(companyId, category);
	}

	public ArrayList<Coupon> getCompanyCoupons(double maxPrice) throws CouponSystemException {
		return couponsDAO.getAllCouponsForCompanyMax(companyId, maxPrice);
	}

	public Company getCompanyDetails() throws CouponSystemException {
		return companiesDAO.getOneCompany(companyId);
	}

}
