package coupons.core.dao;

import java.util.ArrayList;

import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;

public interface CustomersDAO {

	/**
	 * Check if customer exists
	 * @param email
	 * @param password
	 * @return
	 * @throws CouponSystemException
	 */
	boolean isCustomerExists(String email, String password) throws CouponSystemException;
	
	/**
	 * Add a customer to the customers database
	 * @param customer
	 * @return automatically generated customer id from database of customer created
	 * @throws CouponSystemException
	 */
	int addCustomer(Customer customer) throws CouponSystemException;
	
	/**
	 * Update one customer in companies database
	 * @param customer
	 * @throws CouponSystemException
	 */
	void updateCustomer(Customer customer) throws CouponSystemException;
	
	/**
	 * Delete customer from customers database
	 * @param customerId
	 * @throws CouponSystemException
	 */
	void deleteCustomer(int customerId) throws CouponSystemException;
	
	/**
	 * Get all customers from customers database
	 * @return ArrayList<Customer>
	 * @throws CouponSystemException
	 */
	ArrayList<Customer> getAllCustomers() throws CouponSystemException;
	
	/**
	 * Get one customer from customers database
	 * @param customerId
	 * @return Customer
	 * @throws CouponSystemException
	 */
	Customer getOneCustomer(int customerId) throws CouponSystemException;
}
