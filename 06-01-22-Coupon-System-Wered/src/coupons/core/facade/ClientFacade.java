package coupons.core.facade;

import coupons.core.dao.CompaniesDAO;
import coupons.core.dao.CouponsDAO;
import coupons.core.dao.CustomersDAO;
import coupons.core.exceptions.CouponSystemException;

public abstract class ClientFacade{

	protected CompaniesDAO companiesDAO;
	protected CustomersDAO customersDAO;
	protected CouponsDAO couponsDAO;
	
	public abstract boolean login(String email, String password) throws CouponSystemException;
	
}
