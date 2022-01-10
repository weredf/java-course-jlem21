package coupons.core.job;

import coupons.core.dao.CouponsDAO;

public class CouponExpirationDailyJob implements Runnable {

	// job once a day that deletes expired coupons
		// (getAllCoupons, look for expired
		// endDate in list, delete those couponIds from database)
	// need thread that continuously runs

	private CouponsDAO couponsDAO;
	private boolean quit;

	public CouponExpirationDailyJob() {
	}

	public CouponExpirationDailyJob(CouponsDAO couponsDAO, boolean quit) {
		super();
		this.couponsDAO = couponsDAO;
		this.quit = quit;
	}

	@Override
	public void run() {

	}

	public void stop() {

	}

}
