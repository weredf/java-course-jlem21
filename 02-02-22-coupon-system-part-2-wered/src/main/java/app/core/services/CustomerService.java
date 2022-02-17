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
public class CustomerService extends ClientService {

	private int customerId;

	/**
	 * Login to CustomerService
	 */
	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		if (customerRepo.existsByEmailAndPassword(email, password)) {
			this.customerId = customerRepo.getByEmailAndPassword(email, password).getId();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check if coupon exists, if not already purchased by logged in customer, if
	 * amount is not 0. Add coupon purchase, amount minus 1.
	 * 
	 * @param coupon
	 * @throws CouponSystemException
	 */
	public void purchaseCoupon(Coupon coupon) throws CouponSystemException {
		Optional<Coupon> opt1 = couponRepo.findByIdAndCustomersId(coupon.getId(), customerId);
		if (opt1.isEmpty()) {
			Optional<Coupon> opt2 = couponRepo.findById(coupon.getId());
			if (opt2.isPresent()) {
				coupon = opt2.get();
				int amount = coupon.getAmount();
				if (amount > 0) {
					getCustomerDetails().addCoupon(coupon);
					coupon.setAmount(amount - 1);
				} else
					throw new CouponSystemException("purchaseCoupon failed - coupon amount finished");
			} else
				throw new CouponSystemException("purchaseCoupon failed - coupon doesn't exist");
		} else {
			throw new CouponSystemException("purchaseCoupon failed - coupon already purchased");
		}
	}

	/**
	 * Get all coupons by logged in customer
	 * @return List of coupons
	 * @throws CouponSystemException
	 */
	public List<Coupon> getCustomerCoupons() throws CouponSystemException {
		List<Coupon> coupons = couponRepo.findByCustomersId(customerId);
		return coupons;

	}

	/**
	 * Get all coupons by logged in customer in specific category
	 * @param category
	 * @return List of coupons
	 * @throws CouponSystemException
	 */
	public List<Coupon> getCustomerCoupons(Category category) throws CouponSystemException {
		List<Coupon> coupons = couponRepo.findByCategoryAndCustomersId(category, customerId);
		return coupons;

	}

	/**
	 * Get all coupons by logged in company up to max price
	 * @param maxPrice
	 * @return List of coupons
	 * @throws CouponSystemException
	 */
	public List<Coupon> getCustomerCoupons(double maxPrice) throws CouponSystemException {
		List<Coupon> coupons = couponRepo.findByPriceLessThanEqualAndCustomersId(maxPrice, customerId);
		return coupons;

	}

	/**
	 * Get logged in customer
	 * @return customer
	 * @throws CouponSystemException
	 */
	public Customer getCustomerDetails() throws CouponSystemException {
		Customer customer = customerRepo.findById(customerId).get();
		return customer;
	}

}
