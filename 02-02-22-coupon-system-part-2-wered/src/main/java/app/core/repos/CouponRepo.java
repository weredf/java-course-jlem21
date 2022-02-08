package app.core.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Category;
import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.exceptions.CouponSystemException;

public interface CouponRepo extends JpaRepository<Coupon, Integer> {

	List<Coupon> findByCompany(Company company) throws CouponSystemException;

	List<Coupon> findByCompanyAndCategory(Company company, Category category) throws CouponSystemException;

	// look up how to define up to max
	List<Coupon> findByCompanyAndPrice(Company company, double maxPrice) throws CouponSystemException;

	List<Coupon> findByCustomer(Customer customer) throws CouponSystemException;

	List<Coupon> findByCustomerAndCategory(Customer customerDetails, Category category) throws CouponSystemException;

	
	
}
