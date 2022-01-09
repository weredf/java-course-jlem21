package coupons.core.facade;

import coupons.core.beans.Coupon;
import coupons.core.exceptions.CouponSystemException;

public class CustomerFacade extends ClientFacade {

	private int customerId;

	public CustomerFacade(int customerId) {
		super();
		this.customerId = customerId;
	}

	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		return super.login(email, password);
	}
	
	public void purchaseCoupon(Coupon coupon) {
		
	}
	
	
}
