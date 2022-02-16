package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.aspects.StatisticsAspect;
import app.core.dao.company.Company;
import app.core.dao.company.CompanyDao;
import app.core.dao.coupon.CouponDao;

public class App {

	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
			// get beans
			CompanyDao companyDao = ctx.getBean(CompanyDao.class);
			CouponDao couponDao = ctx.getBean(CouponDao.class);
			// prints out proxy types (only when identified as needed)
			System.out.println(companyDao.getClass());
			System.out.println(couponDao.getClass());

			// use beans
			companyDao.addCompany(101, "COM");
			companyDao.addCompany(new Company());
			companyDao.addCompany(new Company());
			companyDao.addCompany(new Company());
			companyDao.sayHello();
			couponDao.addCoupon();
			couponDao.doWork();
			
			StatisticsAspect statisticsAspect = ctx.getBean(StatisticsAspect.class);
			System.out.println("number of calls: " + statisticsAspect.getNumberOfAddCalls());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}
