package coupons.core.dao;

import java.util.ArrayList;

import coupons.core.beans.Company;

public interface CompaniesDAO {

	public boolean isCompanyExists(String email, String Password) {
		return false;
	}
	
	public void addCompany(Company company) {
		
	}
	
	public void updateCompany(Company company) {
		
	}
	
	public void deleteCompany(int companyId) {
		
	}
	
	public ArrayList<Company> getAllCompanies() {
		return null;
	}
	
	public Company getOneCompany(int companyId) {
		return null;
	}
}
