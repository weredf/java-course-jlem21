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
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	// to do
	public boolean login() {
		return false;
	}
	
	@PostMapping(value ="/add-company/{company}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> addCompany(@RequestBody Company company) throws CouponSystemException {
		int id = adminService.addCompany(company);
		return ResponseEntity.ok("company added, id: " + id);
	}
	
	@PutMapping(value = "/update-company/{company}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> updateCompany(@RequestBody Company company) throws CouponSystemException {
		adminService.updateCompany(company);
		return ResponseEntity.ok("company updated: " + company);
	}
	
	@DeleteMapping("/{companyId}")
	public ResponseEntity<?> deleteCompany(@RequestParam int companyId) throws CouponSystemException {
		adminService.deleteCompany(companyId);
		return ResponseEntity.ok("company deleted: " + companyId);
	}
	
	@GetMapping(path = "/get-all-companies", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getAllCompanies() throws CouponSystemException {
		List<Company> companies = adminService.getAllCompanies();
		ResponseEntity<?> re = new ResponseEntity<>(companies, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path = "/get-company/{companyId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getOneCompany(@PathVariable int companyId) throws CouponSystemException{
		Company company = adminService.getOneCompany(companyId);
		ResponseEntity<?> re = new ResponseEntity<>(company, HttpStatus.OK);
		return re;
	}
	
	@PostMapping(value ="/add-customer/{customer}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public int addCustomer(@RequestBody Customer customer) throws CouponSystemException {
		return adminService.addCustomer(customer);
	}
	
	@PutMapping(value = "/update-customer/{customer}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) throws CouponSystemException {
		adminService.updateCustomer(customer);
		return ResponseEntity.ok("customer updated: " + customer);
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomer(@RequestParam int customerId) throws CouponSystemException {
		adminService.deleteCustomer(customerId);
		return ResponseEntity.ok("customer deleted: " + customerId);
	}
	
	@GetMapping(path = "/get-all-customers", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getAllCustomers() throws CouponSystemException {
		List<Customer> customers = adminService.getAllCustomers();
		ResponseEntity<?> re = new ResponseEntity<>(customers, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path = "/get-customer/{customerId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getOneCustomer(@PathVariable int customerId) throws CouponSystemException{
		Customer customer = adminService.getOneCustomer(customerId);
		ResponseEntity<?> re = new ResponseEntity<>(customer, HttpStatus.OK);
		return re;
	}
	
}
