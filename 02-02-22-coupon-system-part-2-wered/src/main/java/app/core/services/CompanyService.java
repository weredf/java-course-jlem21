package app.core.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import app.core.entities.Category;
import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.exceptions.CouponSystemException;

@Service
@Transactional
@Scope("prototype")
public class CompanyService extends ClientService{

	private int companyId;
	
	/**
	 * Login to CompanyService
	 */
	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		Optional<Company> opt = companyRepo.findByEmailAndPassword(email, password);
		if (opt.isPresent()) {
			this.companyId = opt.get().getId();
			return true;
		} else {
			return false;
		}
			
	}
	
	/**
	 * Check if coupon exists for this company, and if title not already in use
	 * @param coupon
	 * @return coupon id
	 * @throws CouponSystemException
	 */
	public int addCoupon (Coupon coupon) throws CouponSystemException {
		Optional<Coupon> opt = couponRepo.findByCompanyIdAndTitle(companyId, coupon.getTitle());
		if (opt.isEmpty()) {
			getCompanyDetails().addCoupon(coupon);
			return couponRepo.save(coupon).getId();
		} else {
			throw new CouponSystemException("addCoupon failed - coupon title " + coupon.getTitle() + " already in use");
		}
	}
	
	/**
	 * Check if coupon exists by id, set company to logged in company
	 * @param coupon
	 * @throws CouponSystemException
	 */
	public void updateCoupon (Coupon coupon) throws CouponSystemException {
		Optional<Coupon> opt = couponRepo.findById(coupon.getId());
		if(opt.isPresent()) {
			coupon.setCompany(getCompanyDetails());
			couponRepo.save(coupon);
		} else {
			throw new CouponSystemException("updateCoupon failed - coupon " + coupon.getId() + " doesn't exist");
		}
	}
	
	/**
	 * Delete coupon by id
	 * @param couponId
	 * @throws CouponSystemException
	 */
	public void deleteCoupon (int couponId) throws CouponSystemException {
		Optional<Coupon> opt = couponRepo.findById(couponId);
		if(opt.isPresent()) {
			couponRepo.deleteById(couponId);
		} else {
			throw new CouponSystemException("deleteCoupon failed - coupon " + couponId + " doesn't exist");
		}
	}
	
	/**
	 * Get all coupons by logged in company
	 * @return List of coupons
	 * @throws CouponSystemException
	 */
	public List<Coupon> getCompanyCoupons() throws CouponSystemException {
		List<Coupon> coupons = couponRepo.findByCompany(getCompanyDetails());
		return coupons;
		
	}

	/**
	 * Get all coupons by logged in company in specific category
	 * @param category
	 * @return List of coupons
	 * @throws CouponSystemException
	 */
	public List<Coupon> getCompanyCoupons(Category category) throws CouponSystemException {
		List<Coupon> coupons = couponRepo.findByCompanyAndCategory(getCompanyDetails(), category);
		return coupons;
	}

	/**
	 * Get all coupons by logged in company up to max price
	 * @param maxPrice
	 * @return List of coupons
	 * @throws CouponSystemException
	 */
	public List<Coupon> getCompanyCoupons(double maxPrice) throws CouponSystemException {
		List<Coupon> coupons = couponRepo.findByPriceLessThanEqualAndCompany(maxPrice, getCompanyDetails());
		return coupons;
	}
	
	/**
	 * Get logged in company
	 * @return company
	 * @throws CouponSystemException
	 */
	public Company getCompanyDetails() throws CouponSystemException {
		return companyRepo.findById(companyId).get();
		
	}
}
