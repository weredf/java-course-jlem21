package app.core.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import app.core.exceptions.CouponSystemException;
import app.core.services.ClientService;

@Component
@Scope("singleton")
public class LoginManager {

	@Autowired
	private ApplicationContext ctx;
	
	public ClientService login(String email, String password, ClientType clientType) throws CouponSystemException {
		if (clientType == ClientType.ADMINISTRATOR) {
			ClientService admin = ctx.getBean("adminService", ClientService.class);
			if (admin.login(email, password)) {
				return admin;
			} else {
				return null;
			}
		} else if (clientType == ClientType.COMPANY) {
			ClientService comp = ctx.getBean("companyService", ClientService.class);
			if (comp.login(email, password)) {
				return comp;
			} else {
				return null;
			}
		} else if (clientType == ClientType.CUSTOMER) {
			ClientService cust = ctx.getBean("customerService", ClientService.class);
			if (cust.login(email, password)) {
				return cust;
			} else {
				return null;
			}
		}
		return null;
	}
}
