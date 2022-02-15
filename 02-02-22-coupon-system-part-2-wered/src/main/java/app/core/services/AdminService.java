package app.core.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import app.core.entities.Company;
import app.core.entities.Customer;
import app.core.exceptions.CouponSystemException;

@Service
@Transactional
public class AdminService extends ClientService{

	@Value("${admin.email}")
	private String email;
	@Value("${admin.password}")
	private String password;
	
	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		return email.equals(this.email) && password.equals(this.password);
	}
	
	public int addCompany(Company company) throws CouponSystemException{
		if (!companyRepo.existsByEmail(company.getEmail())) {
			return companyRepo.save(company).getId();
		} else {
			throw new CouponSystemException("addCompany failed - email already in use");
		}
	}
	
	public void updateCompany(Company company) throws CouponSystemException {
		Optional<Company> opt = companyRepo.findById(company.getId());
		if (opt.isPresent()) {
			company.setName(opt.get().getName());
			companyRepo.save(company);
		} else {
			throw new CouponSystemException("updateCompany failed - company with id " + company.getId() + " doesn't exist");
		}
	}
	
	public void deleteCompany(int companyId) throws CouponSystemException {
		Optional<Company> opt = companyRepo.findById(companyId);
		if(opt.isPresent()) {
			companyRepo.deleteById(companyId);
		} else {
			throw new CouponSystemException("deleteCompany failed - company with id " + companyId + " doesn't exist");
		}
	}
	
	public List<Company> getAllCompanies() {
		List<Company> companies = companyRepo.findAll();
		return companies;
	}
	
	public Company getOneCompany(int companyId) throws CouponSystemException {
		Optional<Company> opt = companyRepo.findById(companyId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			 throw new CouponSystemException("getOneCompany failed - company with id " + companyId + " doesn't exist");
		}
	}
	
	public int addCustomer (Customer customer) throws CouponSystemException {
		if (!customerRepo.existsByEmail(customer.getEmail())) {
			return customerRepo.save(customer).getId();
		} else {
			throw new CouponSystemException("addCustomer failed - email already in use");
		}
	}
	
	public void updateCustomer (Customer customer) throws CouponSystemException {
		Optional<Customer> opt = customerRepo.findById(customer.getId());
		if (opt.isPresent()) {
			customerRepo.save(customer);
		} else {
			throw new CouponSystemException("updateCustomer failed - customer doesn't exist");
		}
	}
	
	public void deleteCustomer (int customerId) throws CouponSystemException {
		if (customerRepo.existsById(customerId)) {
			customerRepo.deleteById(customerId);
		} else {
			throw new CouponSystemException("deleteCustomer failed - customer doesn't exist");
		}
	}
	
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerRepo.findAll();
		return customers;
	}
	
	public Customer getOneCustomer(int customerId) throws CouponSystemException {
		Optional<Customer> opt = customerRepo.findById(customerId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			 throw new CouponSystemException("getOneCustomer failed - customer doesn't exist");
		}
	}

}
