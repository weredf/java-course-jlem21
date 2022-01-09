package coupons.core.dao;

import java.util.ArrayList;

import coupons.core.beans.Company;
import coupons.core.exceptions.CouponSystemException;

public interface CompaniesDAO {

	boolean isCompanyExists(String email, String password) throws CouponSystemException;
	
	// return company id of company created
	int addCompany(Company company) throws CouponSystemException;
	
	/**
	 * 
	 * @param company
	 * @throws CouponSystemException if the company specified is not found or some SQL error
	 */
	void updateCompany(Company company) throws CouponSystemException;
	
	void deleteCompany(int companyId) throws CouponSystemException;
	
	ArrayList<Company> getAllCompanies() throws CouponSystemException;
	
	Company getOneCompany(int companyId) throws CouponSystemException;
}
