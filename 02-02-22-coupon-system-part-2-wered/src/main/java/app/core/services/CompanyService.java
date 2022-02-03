package app.core.services;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import app.core.exceptions.CouponSystemException;

@Service
@Transactional
@Scope("prototype")
public class CompanyService extends ClientService{

	private int companyId;
	
	@Override
	public boolean login(String email, String password) throws CouponSystemException {
		// TODO Auto-generated method stub
		return false;
	}

}
