package coupons.core.facade;

import java.util.ArrayList;

import coupons.core.beans.Company;
import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;

public class AdminFacade extends ClientFacade{

	private String email = "admin@admin.com";
	private String password = "admin";
	
	public AdminFacade() {
		super();
	}

	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		return email.equals(this.email) && password.equals(this.password);
	}
	
	public void addCompany(Company company) throws CouponSystemException {
		// check if company doesn't already exist, if email isn't already used (separately?)
		String email = company.getEmail();
		String pw = company.getPassword();
		if (!companiesDAO.isCompanyExists(email, pw)) {
			// add company
			companiesDAO.addCompany(company);
		}
	}
	
	public void updateCompany(Company company) throws CouponSystemException {
		// check if company exists
		if (companiesDAO.isCompanyExists(company.getId())) {
			// update company
			// check if values are right? Cannot update companyId or name
			companiesDAO.updateCompany(companiesDAO.getOneCompany(company.getId()));
		}
	}
	
	public void deleteCompany(int companyId) throws CouponSystemException {
		// check if company exists
		Company company = companiesDAO.getOneCompany(companyId);
		String email = company.getEmail();
		String pw = company.getPassword();
		if (companiesDAO.isCompanyExists(email, pw)) {
			// first delete coupon purchases for this company by customers
			companiesDAO.deleteCompanyCouponPurchase(companyId);
			// then delete all coupons the company had
			companiesDAO.deleteCompanyCoupon(companyId);
			// lastly delete company
			companiesDAO.deleteCompany(companyId);
		}
	}
	
	public ArrayList<Company> getAllCompanies() {
		return null;
	}
	
	public Company getOneCompany(int companyId) {
		return null;
	}

	public void addCustomer(Customer customer) {
		// check if customer doesn't already exist - email
		// check if values are right?
		// add customer
	}
	
	public void updateCustomer(Customer customer) {
		// check if customer exists
		// check if values are right? Cannot update customerId
		// update customer
	}
	
	public void deleteCustomer(int customerId) {
		// check if customer exists
		// delete customer
		// delete all coupon purchases by customers
	}
	
	public ArrayList<Customer> getAllCustomers() {
		return null;
	}
	
	public Customer getOneCustomer(int customerId) {
		return null;
	}
}
