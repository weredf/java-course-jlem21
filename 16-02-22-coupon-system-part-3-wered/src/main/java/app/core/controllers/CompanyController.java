package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Category;
import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.exceptions.CouponSystemException;
import app.core.jwt.util.JwtUtil;
import app.core.services.CompanyService;

@CrossOrigin
@RestController
@RequestMapping("/api/COMPANY")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private JwtUtil jwtUtil;
	
	/*
	// to do (id is not unique, email is!)
	@PutMapping("/login")
	public String login(@RequestHeader String token) {
		if(jwtUtil.extractClient(token).getClientType() == ClientType.COMPANY) {
			companyService.setCompanyId(jwtUtil.extractClient(token).getClientId());
			return "You are logged in as company " + jwtUtil.extractClient(token).toString();
		} else {
			return "Wrong client type";
		}
	}
	*/
	
	@PostMapping(value = "/add-coupon/{coupon}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> addCoupon(@RequestBody Coupon coupon, @RequestHeader String token) throws CouponSystemException {
		try {
			int companyId = jwtUtil.extractClient(token).getClientId();
			int id = companyService.addCoupon(coupon, companyId);
			return ResponseEntity.ok("coupon added, id: " + id); 
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping(value = "/update-coupon/{coupon}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> updateCoupon(@RequestBody Coupon coupon, @RequestHeader String token) throws CouponSystemException {
		try {
			int companyId = jwtUtil.extractClient(token).getClientId();
			companyService.updateCoupon(coupon, companyId);
			return ResponseEntity.ok("coupon updated: " + coupon);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{couponId}")
	public ResponseEntity<?> deleteCoupon(@RequestParam int couponId, @RequestHeader String token) throws CouponSystemException {
		try {
			int companyId = jwtUtil.extractClient(token).getClientId();
			companyService.deleteCoupon(couponId, companyId);
			return ResponseEntity.ok("coupon deleted: " + couponId);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping(path = "/get-company-coupons", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCompanyCoupons(@RequestHeader String token) throws CouponSystemException {
		try {
			int companyId = jwtUtil.extractClient(token).getClientId();
			List<Coupon> coupons = companyService.getCompanyCoupons(companyId);
			ResponseEntity<?> re = new ResponseEntity<>(coupons, HttpStatus.OK);
			return re;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping(path = "/get-company-coupons/{category}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCompanyCoupons(Category category, @RequestHeader String token) throws CouponSystemException {
		try {
			int companyId = jwtUtil.extractClient(token).getClientId();
			List<Coupon> coupons = companyService.getCompanyCoupons(category, companyId);
			ResponseEntity<?> re = new ResponseEntity<>(coupons, HttpStatus.OK);
			return re;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} 
	}
	
	@GetMapping(path = "/get-company-coupons/{maxPrice}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCompanyCoupons(double maxPrice, @RequestHeader String token) throws CouponSystemException {
		try {
			int companyId = jwtUtil.extractClient(token).getClientId();
			List<Coupon> coupons = companyService.getCompanyCoupons(maxPrice, companyId);
			ResponseEntity<?> re = new ResponseEntity<>(coupons, HttpStatus.OK);
			return re;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping(path = "/{companyId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getCompanyDetails(@RequestHeader String token) throws CouponSystemException{
		try {
			int companyId = jwtUtil.extractClient(token).getClientId();
			Company company = companyService.getCompanyDetails(companyId);
			ResponseEntity<?> re = new ResponseEntity<>(company, HttpStatus.OK);
			return re;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
}
