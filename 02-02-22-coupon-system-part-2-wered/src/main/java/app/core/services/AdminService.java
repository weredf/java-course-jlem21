package app.core.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import app.core.exceptions.CouponSystemException;

@Service
@Transactional
public class AdminService extends ClientService{
	// singleton?
	private String email;
	private String password;
	
	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		return email.equals(this.email) && password.equals(this.password);
	}

}
