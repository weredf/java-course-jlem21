package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import app.core.entities.Category;
import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.exceptions.CouponSystemException;
import app.core.services.CustomerService;

//@RestController
@RequestMapping("/api/company")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	// to do
	public boolean login() {
		return false;
	}
	
	// to check
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> purchaseCoupon(@RequestBody Coupon coupon) throws CouponSystemException {
		customerService.purchaseCoupon(coupon);
		return ResponseEntity.ok("coupon purchased: " + coupon);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCustomerCoupons() throws CouponSystemException {
		List<Coupon> coupons = customerService.getCustomerCoupons();
		ResponseEntity<?> re = new ResponseEntity<>(coupons, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path = "/{category}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCustomerCoupons(Category category) throws CouponSystemException {
		List<Coupon> coupons = customerService.getCustomerCoupons(category);
		ResponseEntity<?> re = new ResponseEntity<>(coupons, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path = "/{maxPrice}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCustomerCoupons(double maxPrice) throws CouponSystemException {
		List<Coupon> coupons = customerService.getCustomerCoupons(maxPrice);
		ResponseEntity<?> re = new ResponseEntity<>(coupons, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path = "/{customerId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCustomerDetails() throws CouponSystemException{
		Customer customer = customerService.getCustomerDetails();
		ResponseEntity<?> re = new ResponseEntity<>(customer, HttpStatus.OK);
		return re;
	}
	
}
