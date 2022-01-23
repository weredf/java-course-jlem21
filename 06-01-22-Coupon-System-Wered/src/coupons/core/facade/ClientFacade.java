package coupons.core.facade;

import coupons.core.dao.CompaniesDAO;
import coupons.core.dao.CompaniesDBDAO;
import coupons.core.dao.CouponsDAO;
import coupons.core.dao.CouponsDBDAO;
import coupons.core.dao.CustomersDAO;
import coupons.core.dao.CustomersDBDAO;
import coupons.core.exceptions.CouponSystemException;

public abstract class ClientFacade{

	protected CompaniesDAO companiesDAO = new CompaniesDBDAO();
	protected CustomersDAO customersDAO = new CustomersDBDAO();
	protected CouponsDAO couponsDAO = new CouponsDBDAO();
	
	/**
	 * @param email
	 * @param password
	 * @return boolean
	 * @throws CouponSystemException
	 */
	public abstract boolean login(String email, String password) throws CouponSystemException;
	
}
