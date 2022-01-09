package coupons.core.dao;

import java.util.ArrayList;

import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;

public interface CustomersDAO {

	boolean isCustomerExists(String email, String password) throws CouponSystemException;
	
	int addCustomer(Customer customer) throws CouponSystemException;
	
	void updateCustomer(Customer customer) throws CouponSystemException;
	
	void deleteCustomer(int customerId) throws CouponSystemException;
	
	ArrayList<Customer> getAllCustomers() throws CouponSystemException;
	
	Customer getOneCustomer(int customerId) throws CouponSystemException;
}
