package app.core.services;

import java.util.ArrayList;

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
		
	}
	
	public ArrayList<Coupon> getCustomerCoupons() throws CouponSystemException {
		ArrayList<Coupon> coupons = couponRepo.findByCustomer(getCustomerDetails());
		return coupons;
		
	}

	public ArrayList<Coupon> getCustomerCoupons(Category category) throws CouponSystemException {
		ArrayList<Coupon> coupons = couponRepo.findByCustomerAndCategory(getCustomerDetails(), category);
		return coupons;
		
	}

	public ArrayList<Coupon> getCustomerCoupons(double maxPrice) {
		return null;
		
	}
	
	public Customer getCustomerDetails() {
		return customerRepo.getById(customerId);
	}

}
