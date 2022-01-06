package coupons.core.dao;

import java.util.ArrayList;

import coupons.core.beans.Customer;

public interface CustomersDAO {

	public boolean isCustomerExists(String email, String Password) {
		return false;
	}
	
	public void addCustomer(Customer customer) {
		
	}
	
	public void updateCustomer(Customer customer) {
		
	}
	
	public void deleteCustomer(int customerId) {
		
	}
	
	public ArrayList<Customer> getAllCustomers() {
		return null;
	}
	
	public Customer getOneCustomer(int customerId) {
		return null;
	}
}
