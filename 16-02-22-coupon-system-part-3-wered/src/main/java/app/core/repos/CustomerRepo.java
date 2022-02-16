package app.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.exceptions.CouponSystemException;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	/**
	 * Check if customer exists by email and password
	 * @param email
	 * @param password
	 * @return boolean
	 * @throws CouponSystemException
	 */
	boolean existsByEmailAndPassword(String email, String password) throws CouponSystemException;

	/**
	 * Check if customer exists by email
	 * @param email
	 * @return boolean
	 * @throws CouponSystemException
	 */
	boolean existsByEmail(String email) throws CouponSystemException;

	/**
	 * Get one coupon by email and password
	 * @param email
	 * @param password
	 * @return coupon
	 * @throws CouponSystemException
	 */
	Customer getByEmailAndPassword(String email, String password) throws CouponSystemException;

}
