package app.core.services;

import java.util.ArrayList;
import java.util.List;

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
	
	public void purchaseCoupon(Coupon coupon) {
		getCustomerDetails().addCoupon(coupon); // also in coupon, add customer?
	}
	
	public List<Coupon> getCustomerCoupons() throws CouponSystemException {
		List<Coupon> coupons = couponRepo.findByCustomer(getCustomerDetails());
		return coupons;
		
	}

	public List<Coupon> getCustomerCoupons(Category category) throws CouponSystemException {
		List<Coupon> coupons = couponRepo.findByCustomerAndCategory(getCustomerDetails(), category);
		return coupons;
		
	}

	public List<Coupon> getCustomerCoupons(double maxPrice) throws CouponSystemException {
		List<Coupon> customerCoupons = getCustomerCoupons();
		List<Coupon> coupons = new ArrayList<>();
			for (Coupon coupon : customerCoupons) {
				if(coupon.getPrice() <= maxPrice) {
					coupons.add(coupon);
				}
			}
		return coupons;
		
	}
	
	public Customer getCustomerDetails() {
		return customerRepo.getById(customerId);
	}

}
