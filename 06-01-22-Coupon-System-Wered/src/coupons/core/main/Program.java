package coupons.core.main;

import coupons.core.exceptions.CouponSystemException;
import tests.main.Test;

public class Program {
	
	public static void main(String[] args) {
		
		try {
			Test.testAll();
		} catch (CouponSystemException e) {
			System.out.println("Error " + e.getMessage());
		}
	}

}
