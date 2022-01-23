package coupons.core.login;

import coupons.core.exceptions.CouponSystemException;
import coupons.core.facade.AdminFacade;
import coupons.core.facade.ClientFacade;
import coupons.core.facade.CompanyFacade;
import coupons.core.facade.CustomerFacade;

public class LoginManager {

	private static LoginManager instance = new LoginManager();
	
	private LoginManager() {
	}

	public static LoginManager getInstance() {
		return instance;
	}
	
	public ClientFacade login(String email, String password, ClientType clientType) throws CouponSystemException {
		// check if entered login values are correct users according to client type
		if (clientType == ClientType.ADMINISTRATOR) {
			ClientFacade admin = new AdminFacade();
			if (admin.login(email, password)) {
				return admin;
			} else {
				return null;
			}
		} else if (clientType == ClientType.COMPANY) {
			ClientFacade comp = new CompanyFacade();
			if (comp.login(email, password)) {
				return comp;
			} else {
				return null;
			}
		} else if (clientType == ClientType.CUSTOMER) {
			ClientFacade cust = new CustomerFacade();
			if (cust.login(email, password)) {
				return cust;
			} else {
				return null;
			}
		}
		return null;
	}
}
