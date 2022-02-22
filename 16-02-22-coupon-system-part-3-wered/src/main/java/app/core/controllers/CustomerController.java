package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Category;
import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.exceptions.CouponSystemException;
import app.core.services.CustomerService;

@RestController
@RequestMapping("/api/company")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	// to do (id is not unique, email is!)
	public boolean login() {
		return false;
	}
	
	// to check
	@PostMapping(value = "/purchase-coupon/{coupon}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> purchaseCoupon(@RequestBody Coupon coupon, @RequestHeader String token) throws CouponSystemException {
		customerService.purchaseCoupon(coupon);
		return ResponseEntity.ok("coupon purchased: " + coupon);
	}
	
	@GetMapping(path = "/get-customer-coupons", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCustomerCoupons(@RequestHeader String token) throws CouponSystemException {
		try {
			List<Coupon> coupons = customerService.getCustomerCoupons();
			ResponseEntity<?> re = new ResponseEntity<>(coupons, HttpStatus.OK);
			return re;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping(path = "/get-customer-coupons/{category}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCustomerCoupons(Category category, @RequestHeader String token) throws CouponSystemException {
		try {
			List<Coupon> coupons = customerService.getCustomerCoupons(category);
			ResponseEntity<?> re = new ResponseEntity<>(coupons, HttpStatus.OK);
			return re;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	
	@GetMapping(path = "/get-customer-coupons/{maxPrice}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCustomerCoupons(double maxPrice, @RequestHeader String token) throws CouponSystemException {
		try {
			List<Coupon> coupons = customerService.getCustomerCoupons(maxPrice);
			ResponseEntity<?> re = new ResponseEntity<>(coupons, HttpStatus.OK);
			return re;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping(path = "/{customerId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCustomerDetails(@RequestHeader String token) throws CouponSystemException{
		try {
			Customer customer = customerService.getCustomerDetails();
			ResponseEntity<?> re = new ResponseEntity<>(customer, HttpStatus.OK);
			return re;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
}
