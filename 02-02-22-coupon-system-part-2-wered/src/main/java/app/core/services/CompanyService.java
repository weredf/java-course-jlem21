package app.core.services;

import java.util.ArrayList;
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
	
	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		Optional<Company> opt = Optional.of(companyRepo.findByEmailAndPassword(email, password));
		if (opt.isPresent()) {
			this.companyId = opt.get().getId();
			return true;
		} else {
			return false;
		}
			
	}
	
	public int addCoupon (Coupon coupon) throws CouponSystemException {
		Optional<Coupon> opt = couponRepo.findById(coupon.getCompany().getId());
		if (opt.isEmpty()) {
			Company company = companyRepo.save(coupon.getCompany());
			company.addCoupon(coupon);
			return coupon.getId();
		} else {
			throw new CouponSystemException("addCoupon failed - company " + coupon.getCompany().getId() + " id not found");
		}
	}
	
	public void updateCoupon (Coupon coupon) throws CouponSystemException {
		Optional<Coupon> opt = couponRepo.findById(coupon.getId());
		if(opt.isPresent()) {
			couponRepo.save(coupon);
		} else {
			throw new CouponSystemException("updateCoupon failed - coupon " + coupon.getId() + " doesn't exist");
		}
	}
	
	public void deleteCoupon (int couponId) throws CouponSystemException {
		Optional<Coupon> opt = couponRepo.findById(couponId);
		if(opt.isPresent()) {
			couponRepo.deleteById(couponId);
		} else {
			throw new CouponSystemException("deleteCoupon failed - coupon " + couponId + " doesn't exist");
		}
	}
	
	public List<Coupon> getCompanyCoupons() throws CouponSystemException {
		List<Coupon> coupons = couponRepo.findByCompany(getCompanyDetails());
		return coupons;
		
	}

	public List<Coupon> getCompanyCoupons(Category category) throws CouponSystemException {
		List<Coupon> coupons = couponRepo.findByCompanyAndCategory(getCompanyDetails(), category);
		return coupons;
		
	}

	public List<Coupon> getCompanyCoupons(double maxPrice) throws CouponSystemException {
		List<Coupon> companyCoupons = getCompanyCoupons();
		List<Coupon> coupons = new ArrayList<>();
			for (Coupon coupon : companyCoupons) {
				if(coupon.getPrice() <= maxPrice) {
					coupons.add(coupon);
				}
			}
		return coupons;
		
	}
	
	public Company getCompanyDetails() {
		return companyRepo.getById(companyId);
		
	}
}
