package app.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Company;
import app.core.exceptions.CouponSystemException;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

	boolean existsByEmail(String email) throws CouponSystemException;

	boolean existsByEmailAndPassword(String email, String password) throws CouponSystemException;

	Company getByEmailAndPassword(String email, String password) throws CouponSystemException;

	Company findByEmailAndPassword(String email, String password) throws CouponSystemException;

}
