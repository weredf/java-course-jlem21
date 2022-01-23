package coupons.core.job;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import coupons.core.beans.Coupon;
import coupons.core.dao.CouponsDAO;
import coupons.core.dao.CouponsDBDAO;
import coupons.core.exceptions.CouponSystemException;

public class CouponExpirationDailyJob implements Runnable {

	private CouponsDAO couponsDAO;
	private boolean quit;
	private Thread thread = new Thread(this, "daily_job");

	public CouponExpirationDailyJob(CouponsDAO couponsDAO) {
		this.couponsDAO = new CouponsDBDAO();
	}

	@Override
	public void run(){
		thread.run();
		while(!quit) {
			try {
				ArrayList<Coupon> coupons = couponsDAO.getAllCoupons();
				for (Coupon coupon : coupons) {
					if(LocalDate.now().isAfter(coupon.getEndDate()));
					int id = coupon.getId();
					if (couponsDAO.isCouponPurchaseExists(id)) {
						couponsDAO.deleteCouponPurchase(id);
						couponsDAO.deleteCoupon(id);
					} else if (couponsDAO.isCouponExists(id)){
						couponsDAO.deleteCoupon(id);
					}
				}
				TimeUnit.DAYS.sleep(1);
			} catch (CouponSystemException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Start Daily Job Thread, boolean
	 */
	public void startDailyJob() {
		quit = true;
		this.thread.start();
	}
	
	/**
	 * Stop Daily Job Thread, boolean
	 */
	public void stopDailyJob() {
		quit = false;
		this.thread.interrupt();
	}

}
