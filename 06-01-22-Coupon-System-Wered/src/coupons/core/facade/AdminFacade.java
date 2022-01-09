package coupons.core.facade;

import coupons.core.beans.Company;
import coupons.core.exceptions.CouponSystemException;

public class AdminFacade extends ClientFacade{

	private String email = "admin@admin.com";
	private String password = "admin";
	
	public AdminFacade() {
		super();
	}

	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		return super.login(email, password);
	}
	
	public void addCompany(Company company) {
		// check if company doesn't already exists
		// check if values are right?
		// add company
	}
	
	public void updateCompany(Company company) {
		// check if company exists
		// check if values are right?
		// update company
	}
	
	public void deleteCompany(int companyId) {
		// check if company exists
		// check if values are right?
		// delete company
	}

	
}
