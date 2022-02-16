package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.core.entities.Category;
import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.exceptions.CouponSystemException;
import app.core.services.CompanyService;

//@RestController
@RequestMapping("/api/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	// to do
	public boolean login() {
		return false;
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public int addCoupon(@RequestBody Coupon coupon) throws CouponSystemException {
		return companyService.addCoupon(coupon);
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> updateCoupon(@RequestBody Coupon coupon) throws CouponSystemException {
		companyService.updateCoupon(coupon);
		return ResponseEntity.ok("coupon updated: " + coupon);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteCoupon(@RequestParam int couponId) throws CouponSystemException {
		companyService.deleteCoupon(couponId);
		return ResponseEntity.ok("coupon deleted: " + couponId);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCompanyCoupons() throws CouponSystemException {
		List<Coupon> coupons = companyService.getCompanyCoupons();
		ResponseEntity<?> re = new ResponseEntity<>(coupons, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path = "/{category}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCompanyCoupons(Category category) throws CouponSystemException {
		List<Coupon> coupons = companyService.getCompanyCoupons(category);
		ResponseEntity<?> re = new ResponseEntity<>(coupons, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path = "/{maxPrice}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCompanyCoupons(double maxPrice) throws CouponSystemException {
		List<Coupon> coupons = companyService.getCompanyCoupons(maxPrice);
		ResponseEntity<?> re = new ResponseEntity<>(coupons, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path = "/{companyId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCompanyDetails() throws CouponSystemException{
		Company company = companyService.getCompanyDetails();
		ResponseEntity<?> re = new ResponseEntity<>(company, HttpStatus.OK);
		return re;
	}
	
}