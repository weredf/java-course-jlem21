package coupons.core.facade;

import coupons.core.exceptions.CouponSystemException;

public class CompanyFacade extends ClientFacade {

	private int companyId;

	public CompanyFacade(int companyId) {
		super();
		this.companyId = companyId;
	}

	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		return super.login(email, password);
	}

	
}
