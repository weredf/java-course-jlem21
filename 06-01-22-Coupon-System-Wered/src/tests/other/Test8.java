package tests.other;

import coupons.core.exceptions.CouponSystemException;
import coupons.core.facade.AdminFacade;
import coupons.core.facade.CompanyFacade;
import coupons.core.facade.CustomerFacade;
import coupons.core.login.ClientType;
import coupons.core.login.LoginManager;

public class Test8 {

	public static void main(String[] args) {

		LoginManager manager = LoginManager.getInstance();
		try {
			AdminFacade adminFacade = (AdminFacade) manager.login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
				if (adminFacade!=null) {
					System.out.println("Admin access success!");
				} else {
					System.out.println("Admin access failed!");
				}
			
			CompanyFacade companyFacade = (CompanyFacade) manager.login("bbb@mail.com", "bbbPass", ClientType.COMPANY);
			if (companyFacade!=null) {
				System.out.println("Company access success!");
			} else {
				System.out.println("Company access failed!");
			}
			
			CustomerFacade customerFacade = (CustomerFacade) manager.login("fff@mail.com", "fffPass", ClientType.CUSTOMER);
			if (customerFacade!=null) {
				System.out.println("Customer access success!");
			} else {
				System.out.println("Customer access failed!");
			}
		} catch (CouponSystemException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
