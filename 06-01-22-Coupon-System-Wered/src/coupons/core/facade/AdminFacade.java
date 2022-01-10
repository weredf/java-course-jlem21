package coupons.core.facade;

import java.util.ArrayList;

import coupons.core.beans.Company;
import coupons.core.beans.Coupon;
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
		if (this.email == email && this.password == password) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addCompany(Company company) throws CouponSystemException {
		// check if company doesn't already exist, if email isn't already used
		String email = company.getEmail();
		String pw = company.getEmail();
		if (!companiesDAO.isCompanyExists(email, pw)) {
			// add company
			companiesDAO.addCompany(company);
		}
	}
	
	// circular code, only thing to update is email & pw? to do: overload method!
	public void updateCompany(Company company) throws CouponSystemException {
		// check if company exists
		String email = company.getEmail();
		String pw = company.getEmail();
		if (companiesDAO.isCompanyExists(email, pw)) {
			// update company
			companiesDAO.getOneCompany(company.getId());
			companiesDAO.updateCompany(company);
		// check if values are right? Cannot update companyId or name
		}
	}
	
	public void deleteCompany(int companyId) throws CouponSystemException {
		// check if company exists
		Company company = companiesDAO.getOneCompany(companyId);
		String email = company.getEmail();
		String pw = company.getEmail();
		if (companiesDAO.isCompanyExists(email, pw)) {
			// delete company
			companiesDAO.deleteCompany(companyId);
			// delete all coupons the company had
			ArrayList<Coupon> coupons = couponsDAO.getAllCoupons();
			for (int i = 0; i < coupons.size(); i++) {
				Coupon coupon = coupons.get(i);
				if (coupon.getCompany() == companyId) {
					coupons.remove(i);
				}
			}
			// delete coupon purchases for this company by customers
			ArrayList<Customer> customers = customersDAO.getAllCustomers();
			for (int i = 0; i < customers.size(); i++) {
				Customer customer = customers.get(i);
				//search in customers_vs_coupons
			}
//			deleteCouponPurchase
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
