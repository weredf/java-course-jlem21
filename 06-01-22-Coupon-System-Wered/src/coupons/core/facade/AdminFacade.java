package coupons.core.facade;

import java.util.ArrayList;

import coupons.core.beans.Company;
import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;

public class AdminFacade extends ClientFacade {

	private String email = "admin@admin.com";
	private String password = "admin";

	public AdminFacade() {
		super();
	}

	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		return email.equals(this.email) && password.equals(this.password);
	}

	/**
	 * Add company after checking values
	 * @param company
	 * @throws CouponSystemException
	 */
	public void addCompany(Company company) throws CouponSystemException {
		// check if input is valid
		if (company.getName() != null && company.getEmail() != null & company.getPassword() != null) {
			// check if company name doesn't already exist, if email isn't already used
			if (!companiesDAO.isCompanyExistsNameOrEmail(company.getName(), company.getEmail())) {
				// add company
				companiesDAO.addCompany(company);
			} else {
				throw new CouponSystemException("addCompany failed - company name " + company.getName() + "already exists or email " + company.getEmail() + " already in use");
			}
		} else {
			throw new CouponSystemException("addCompany failed - input not valid");
		}
	}

	/**
	 * Update company after checking values
	 * @param company
	 * @throws CouponSystemException
	 */
	public void updateCompany(Company company) throws CouponSystemException {
		// check if input is valid
		if (company.getId() != 0 && company.getName() != null) {
			// check if company exists
			if (companiesDAO.isCompanyExists(company.getId(), company.getName())) {
				// check if input matches - cannot update company Id or name
				Company c = companiesDAO.getOneCompany(company.getId());
				if (c.getName().equals(company.getName())) {
					// check if update input is valid
					if (company.getEmail() != null && company.getPassword() != null) {
						// update company
						companiesDAO.updateCompany(company);
					} else {
						throw new CouponSystemException("updateCompany failed - update input not valid");
					}
				} else {
					throw new CouponSystemException("updateCompany " + company + " failed - can't update id or name");
				}
			} else {
				throw new CouponSystemException("updateCompany failed - company " + company + "doesn't exist");
			}
		} else {
			throw new CouponSystemException("updateCompany failed - search input not valid");
		}
	}

	/**
	 * Delete company after checking if it exists in relevant tables
	 * @param companyId
	 * @throws CouponSystemException
	 */
	public void deleteCompany(int companyId) throws CouponSystemException {
		// check if company exists
		if (companiesDAO.isCompanyExists(companyId)) {
			// check if coupons exist
			if (companiesDAO.isCompanyCouponExists(companyId)) {
				// check if coupon purchases for this company exist
				if (companiesDAO.isCompanyCouponPurchaseExists(companyId)) {
					// delete coupon purchases for this company by customers
					companiesDAO.deleteCompanyCouponPurchase(companyId);
					// delete all coupons the company had
					companiesDAO.deleteCompanyCoupon(companyId);
					// delete company
					companiesDAO.deleteCompany(companyId);
				} else {
					companiesDAO.deleteCompanyCoupon(companyId);
					companiesDAO.deleteCompany(companyId);
				}
			} else {
				companiesDAO.deleteCompany(companyId);
			}
		} else {
			throw new CouponSystemException("deleteCompany " + companyId + "failed - company doesn't exist");
		}
	}

	/**
	 * Get all companies from companies database
	 * @return ArrayList
	 * @throws CouponSystemException
	 */
	public ArrayList<Company> getAllCompanies() throws CouponSystemException {
		return companiesDAO.getAllCompanies();
	}

	/**
	 * Get one company from companies database
	 * @param companyId
	 * @return Company
	 * @throws CouponSystemException
	 */
	public Company getOneCompany(int companyId) throws CouponSystemException {
		return companiesDAO.getOneCompany(companyId);
	}

	/**
	 * Add customer after checking if it doesn't exist
	 * @param customer
	 * @throws CouponSystemException
	 */
	public void addCustomer(Customer customer) throws CouponSystemException {
		// check if customer doesn't already exist - email
		if (!customersDAO.isCustomerExists(customer.getEmail(), customer.getPassword())) {
			// add customer
			customersDAO.addCustomer(customer);
		} else {
			throw new CouponSystemException("addCustomer failed - customer email " + customer.getEmail() + " already in use");
		}
	}

	/**
	 * Update customer after checking values and exists
	 * @param customer
	 * @throws CouponSystemException
	 */
	public void updateCustomer(Customer customer) throws CouponSystemException {
		// check if search input is valid
		if (customer.getId() != 0) {
			// check if customer exists
			if (customersDAO.isCustomerExists(customer.getId())) {
				// check if update input is valid
				if (customer.getFirstName() != null && customer.getLastName() != null && customer.getEmail() != null
						&& customer.getPassword() != null) {
					// update customer
					customersDAO.updateCustomer(customer);
				} else {
					throw new CouponSystemException("updateCustomer failed - update input not valid");
				}
			} else {
				throw new CouponSystemException("updateCustomer failed - customer " + customer + "already exists");
			}
		} else {
			throw new CouponSystemException("updateCustomer failed - search input not valid");
		}
	}

	/**
	 * Delete customer after checking if it exists in relevant tables
	 * @param customerId
	 * @throws CouponSystemException
	 */
	public void deleteCustomer(int customerId) throws CouponSystemException {
		// check if customer exists
		if (customersDAO.isCustomerExists(customerId)) {
			// check if coupon purchases by customer exist
			if (customersDAO.isCustomerCouponPurchaseExists(customerId)) {
				// delete all coupon purchases by customer
				customersDAO.deleteCustomerCouponPurchase(customerId);
				// delete customer
				customersDAO.deleteCustomer(customerId);
			} else {
				customersDAO.deleteCustomer(customerId);
			}
		} else {
			throw new CouponSystemException("deleteCustomer " + customerId + "failed - customer doesn't exist");
		}
	}

	/**
	 * Get all customers from customers database
	 * @return ArrayList
	 * @throws CouponSystemException
	 */
	public ArrayList<Customer> getAllCustomers() throws CouponSystemException {
		return customersDAO.getAllCustomers();
	}

	/**
	 * Get one customer from customers database
	 * @param customerId
	 * @return Customer
	 * @throws CouponSystemException
	 */
	public Customer getOneCustomer(int customerId) throws CouponSystemException {
		return customersDAO.getOneCustomer(customerId);
	}
}
