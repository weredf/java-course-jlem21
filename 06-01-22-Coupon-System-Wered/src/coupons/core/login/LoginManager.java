package coupons.core.login;

import coupons.core.facade.ClientFacade;

public class LoginManager {

	// initialize or not?
	private static LoginManager instance = new LoginManager();
	
	private LoginManager() {
	}

	public static LoginManager getInstance() {
		return instance;
	}
	
	public ClientFacade login(String email, String password, ClientType clientType) {
		// check if entered login values are correct users according to client type
		// if wrong, return null
		return null;
		// if right, return right type of ClientFacade (Admin, Company, Customer)
	}
}
