package app.core.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import app.core.entities.Category;
import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.exceptions.CouponSystemException;

@Service
@Transactional
@Scope("prototype")
public class CustomerService extends ClientService{

	private int customerId;
	
	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		if (customerRepo.existsByEmailAndPassword(email, password)) {
			this.customerId = customerRepo.getByEmailAndPassword(email, password).getId();
			return true;
		} else {
			return false;
		}
	}
	
	// add check - no double coupon purchases, amount not 0, not expired (job takes care of this?)
	// after purchase: amount -1
	public void purchaseCoupon(Coupon coupon) throws CouponSystemException {
		Optional<Coupon> opt = couponRepo.findByCustomerId(customerId);
		if(opt.isEmpty()) {
			Coupon couponDb = couponRepo.findById(coupon.getId()).get();
			int amount = couponDb.getAmount();
			if(amount != 0) {
				getCustomerDetails().addCoupon(coupon);
				coupon.setAmount(amount--);
				couponRepo.save(coupon); //?
			}
			
			
		}
	}
	
	public List<Coupon> getCustomerCoupons() throws CouponSystemException {
		List<Coupon> coupons = couponRepo.findAll();
		List<Coupon> customerCoupons = new ArrayList<>();
		for (Coupon coupon : coupons) {
			if(coupon.getId() == customerId) {
				customerCoupons.add(coupon);
			}
		}
		return customerCoupons;
		
	}

	public List<Coupon> getCustomerCoupons(Category category) throws CouponSystemException {
		List<Coupon> coupons = getCustomerCoupons();
		List<Coupon> categoryCoupons = new ArrayList<>();
		for (Coupon coupon : coupons) {
			if(coupon.getCategory().equals(category)) {
				categoryCoupons.add(coupon);
			}
		}
		return categoryCoupons;
		
	}

	public List<Coupon> getCustomerCoupons(double maxPrice) throws CouponSystemException {
		List<Coupon> coupons = getCustomerCoupons();
		List<Coupon> maxCoupons = new ArrayList<>();
			for (Coupon coupon : coupons) {
				if(coupon.getPrice() <= maxPrice) {
					maxCoupons.add(coupon);
				}
			}
		return maxCoupons;
		
	}
	
	public Customer getCustomerDetails() {
		return customerRepo.getById(customerId);
	}

}
