package app.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.exceptions.CouponSystemException;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	boolean existsByEmailAndPassword(String email, String password) throws CouponSystemException;

	boolean existsByEmail(String email) throws CouponSystemException;

	Coupon getByEmailAndPassword(String email, String password) throws CouponSystemException;

}
