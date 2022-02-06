package app.core.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import app.core.exceptions.CouponSystemException;

@Service
@Transactional
@PropertySource("admin.properties")
public class AdminService extends ClientService{
	// singleton?
	@Value("${email}")
	private String email;
	@Value("${password}")
	private String password;
	
	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		return email.equals(this.email) && password.equals(this.password);
	}

}
