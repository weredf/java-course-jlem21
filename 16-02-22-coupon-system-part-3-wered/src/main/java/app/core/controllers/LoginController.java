package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.exceptions.CouponSystemException;
import app.core.jwt.util.JwtUtil;
import app.core.jwt.util.JwtUtil.ClientDetails;
import app.core.login.ClientType;
import app.core.login.LoginManager;
import app.core.services.AdminService;
import app.core.services.CompanyService;
import app.core.services.CustomerService;

@RestController
public class LoginController {

	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private LoginManager loginManager;
	
	// also logout method here?
	@PutMapping
	public String login(@RequestParam String email, @RequestParam String password, @RequestParam ClientType clientType) throws CouponSystemException {
		if(this.loginManager.login(email, password, clientType) != null) {
			// generate token and return
			ClientDetails client = new ClientDetails(email, clientType, 0);
			if (clientType == ClientType.ADMINISTRATOR) {
				adminService = (AdminService) loginManager.login(email, password, clientType);
			} else if (clientType == ClientType.COMPANY) {
				companyService = (CompanyService) loginManager.login(email, password, clientType);
				client.setClientId(companyService.getCompanyDetails().getId());
			} else if (clientType == ClientType.CUSTOMER) {
				customerService = (CustomerService) loginManager.login(email, password, clientType);
				client.setClientId(customerService.getCustomerDetails().getId());
			}
			System.out.println(client.getClientId());
			return jwtUtil.generateToken(client);
		} else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "bad credentials");
		}
	}
	
}
