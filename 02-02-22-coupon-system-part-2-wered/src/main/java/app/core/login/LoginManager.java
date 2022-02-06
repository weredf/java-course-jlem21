package app.core.login;

import org.springframework.beans.factory.annotation.Autowired;

import app.core.exceptions.CouponSystemException;
import app.core.services.AdminService;
import app.core.services.ClientService;
import app.core.services.CompanyService;
import app.core.services.CustomerService;


public class LoginManager {

	@Autowired
	private static LoginManager instance = new LoginManager();
	
	private LoginManager() {
	}

	public static LoginManager getInstance() {
		return instance;
	}
	
	public ClientService login(String email, String password, ClientType clientType) throws CouponSystemException {
		// check if entered login values are correct users according to client type
		if (clientType == ClientType.ADMINISTRATOR) {
			ClientService admin = new AdminService();
			if (admin.login(email, password)) {
				return admin;
			} else {
				return null;
			}
		} else if (clientType == ClientType.COMPANY) {
			ClientService comp = new CompanyService();
			if (comp.login(email, password)) {
				return comp;
			} else {
				return null;
			}
		} else if (clientType == ClientType.CUSTOMER) {
			ClientService cust = new CustomerService();
			if (cust.login(email, password)) {
				return cust;
			} else {
				return null;
			}
		}
		return null;
	}
}
