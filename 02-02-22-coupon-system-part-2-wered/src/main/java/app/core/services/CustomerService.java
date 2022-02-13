package app.core.services;

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
		Optional<Coupon> opt1 = couponRepo.findByIdAndCustomersId(coupon.getId(), customerId);
		if(opt1.isEmpty()) {
			Optional<Coupon> opt2 = couponRepo.findById(coupon.getId());
			if(opt2.isPresent()) {
				coupon = opt2.get();
				int amount = coupon.getAmount();
				if(amount > 0) {
					getCustomerDetails().addCoupon(coupon);
					coupon.setAmount(amount--);
					couponRepo.save(coupon); //?
				} else throw new CouponSystemException("purchaseCoupon failed - coupon amount finished");
			} else throw new CouponSystemException("purchaseCoupon failed - coupon doesn't exist");
		} else {
			throw new CouponSystemException("purchaseCoupon failed - coupon already purchased");
		}
	}
	
	public List<Coupon> getCustomerCoupons() throws CouponSystemException {
		List<Coupon> coupons = couponRepo.findByCustomersId(customerId);
		return coupons;
		
	}

	public List<Coupon> getCustomerCoupons(Category category) throws CouponSystemException {
		List<Coupon> coupons = couponRepo.findByCategoryAndCustomersId(category, customerId);
		return coupons;
		
	}

	public List<Coupon> getCustomerCoupons(double maxPrice) throws CouponSystemException {
		List<Coupon> coupons = couponRepo.findByPriceLessThanEqualAndCustomersId(maxPrice, customerId);
		return coupons;
		
	}
	
	public Customer getCustomerDetails() {
		Customer customer = customerRepo.findById(customerId).get();
		return customer;
	}

}
