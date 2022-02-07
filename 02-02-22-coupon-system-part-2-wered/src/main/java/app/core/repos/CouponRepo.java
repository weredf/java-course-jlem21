package app.core.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Category;
import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.exceptions.CouponSystemException;

public interface CouponRepo extends JpaRepository<Coupon, Integer> {

	void deleteExpiredCoupons() throws CouponSystemException;

	ArrayList<Coupon> findByCompany(Company company) throws CouponSystemException;

	ArrayList<Coupon> findByCompanyAndCategory(Company company, Category category) throws CouponSystemException;

	// look up how to define up to max
	ArrayList<Coupon> findByCompanyAndPrice(Company company, double maxPrice) throws CouponSystemException;

	ArrayList<Coupon> findByCustomer(Customer customer) throws CouponSystemException;

	ArrayList<Coupon> findByCustomerAndCategory(Customer customerDetails, Category category) throws CouponSystemException;

	
	
}
