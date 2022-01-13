package coupons.core.dao;

import java.util.ArrayList;

import coupons.core.beans.Company;
import coupons.core.exceptions.CouponSystemException;

public interface CompaniesDAO {

	/**
	 * Check if company exists
	 * @param email
	 * @param password
	 * @return boolean
	 * @throws CouponSystemException
	 */
	boolean isCompanyExists(String email, String password) throws CouponSystemException;
	
	/**
	 * Check if company exists
	 * @param companyId
	 * @return boolean
	 * @throws CouponSystemException
	 */
	boolean isCompanyExists(int companyId) throws CouponSystemException;

	/**
	 * Check if company exists
	 * @param id
	 * @param name
	 * @return boolean
	 * @throws CouponSystemException
	 */
	boolean isCompanyExists(int companyId, String name) throws CouponSystemException;
	
	/**
	 * Check if company name or email are already in use
	 * @param name
	 * @param email
	 * @return boolean
	 * @throws CouponSystemException
	 */
	boolean isCompanyExistsNameOrEmail(String name, String email) throws CouponSystemException;
	
	/**
	 * Check if coupons by company exist
	 * @param companyId
	 * @return boolean
	 * @throws CouponSystemException
	 */
	boolean isCompanyCouponExists(int companyId) throws CouponSystemException;
	
	/**
	 * Check if coupon purchases of company exist
	 * @param companyId
	 * @return boolean
	 * @throws CouponSystemException
	 */
	boolean isCompanyCouponPurchaseExists(int companyId) throws CouponSystemException;

	/**
	 * Add a company to the companies database
	 * @param company
	 * @return automatically generated company id from database of company created
	 * @throws CouponSystemException
	 */
	int addCompany(Company company) throws CouponSystemException;
	
	/**
	 * Update one company in companies database
	 * @param company
	 * @throws CouponSystemException if the company specified is not found or some SQL error
	 */
	void updateCompany(Company company) throws CouponSystemException;
	
	/**
	 * Delete company from companies database
	 * @param companyId
	 * @throws CouponSystemException
	 */
	void deleteCompany(int companyId) throws CouponSystemException;
	
	/**
	 * Delete all coupons of certain company from coupons database
	 * @param companyId
	 * @throws CouponSystemException
	 */
	void deleteCompanyCoupon(int companyId) throws CouponSystemException;
	
	/**
	 * Delete all coupon purchases by customers of coupons by certain company
	 * @param companyId
	 * @throws CouponSystemException
	 */
	void deleteCompanyCouponPurchase (int companyId) throws CouponSystemException;
	
	/**
	 * Get all companies from companies database
	 * @return ArrayList<Company>
	 * @throws CouponSystemException
	 */
	ArrayList<Company> getAllCompanies() throws CouponSystemException;
	
	/**
	 * Get one company from companies database
	 * @param companyId
	 * @return Company
	 * @throws CouponSystemException
	 */
	Company getOneCompany(int companyId) throws CouponSystemException;

}
