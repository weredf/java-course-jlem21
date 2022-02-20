package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Company;
import app.core.entities.Customer;
import app.core.exceptions.CouponSystemException;
import app.core.services.AdminService;

@RestController
@RequestMapping("api/admin")
// add aspect filter!
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	// to do: client login, token (object) from server, client saves token
	// http protocol is stateless. server gets header with token from client
	/**
	 * Login to AdminService
	 * @return adminService through token
	 */
	public String login() {
		String token ="";
		return token;
	}
	
	@PostMapping(value ="/add-company/{company}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> addCompany(@RequestBody Company company) throws CouponSystemException {
		try {
			int id = adminService.addCompany(company);
			return ResponseEntity.ok("company added, id: " + id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping(value = "/update-company/{company}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> updateCompany(@RequestBody Company company) throws CouponSystemException {
		try {
			adminService.updateCompany(company);
			return ResponseEntity.ok("company updated: " + company);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{companyId}")
	public ResponseEntity<?> deleteCompany(@RequestParam int companyId) throws CouponSystemException {
		try {
			adminService.deleteCompany(companyId);
			return ResponseEntity.ok("company deleted: " + companyId);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping(path = "/get-all-companies", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getAllCompanies() throws CouponSystemException {
		try {
			List<Company> companies = adminService.getAllCompanies();
			ResponseEntity<?> re = new ResponseEntity<>(companies, HttpStatus.OK);
			return re;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping(path = "/get-company/{companyId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getOneCompany(@PathVariable int companyId) throws CouponSystemException{
		try {
			Company company = adminService.getOneCompany(companyId);
			ResponseEntity<?> re = new ResponseEntity<>(company, HttpStatus.OK);
			return re;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping(value ="/add-customer/{customer}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) throws CouponSystemException {
		try {
			int id = adminService.addCustomer(customer);
			return ResponseEntity.ok("customer added, id: " + id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping(value = "/update-customer/{customer}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) throws CouponSystemException {
		try {
			adminService.updateCustomer(customer);
			return ResponseEntity.ok("customer updated: " + customer);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomer(@RequestParam int customerId) throws CouponSystemException {
		try {
			adminService.deleteCustomer(customerId);
			return ResponseEntity.ok("customer deleted: " + customerId);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping(path = "/get-all-customers", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getAllCustomers() throws CouponSystemException {
		try {
			List<Customer> customers = adminService.getAllCustomers();
			ResponseEntity<?> re = new ResponseEntity<>(customers, HttpStatus.OK);
			return re;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping(path = "/get-customer/{customerId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getOneCustomer(@PathVariable int customerId) throws CouponSystemException{
		try {
			Customer customer = adminService.getOneCustomer(customerId);
			ResponseEntity<?> re = new ResponseEntity<>(customer, HttpStatus.OK);
			return re;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
}
