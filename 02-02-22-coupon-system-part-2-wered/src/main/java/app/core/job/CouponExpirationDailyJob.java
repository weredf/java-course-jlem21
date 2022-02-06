package app.core.job;

import java.util.concurrent.TimeUnit;

import app.core.repos.CouponRepo;
import app.core.exceptions.CouponSystemException;

public class CouponExpirationDailyJob implements Runnable {

	private static CouponExpirationDailyJob instance = new CouponExpirationDailyJob(couponRepo);
	
	private CouponRepo couponRepo;
	private boolean quit;
	private Thread thread = new Thread(this, "daily_job");

	public CouponExpirationDailyJob(CouponRepo couponRepo) {
	}

	@Override
	public void run(){
		while(!quit) {
			try {
				couponRepo.deleteExpiredCoupons();
				System.out.println("All expired coupons deleted");
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
		System.out.println(">>> Daily job started");
	}
	
	/**
	 * Stop Daily Job Thread, boolean
	 */
	public void stopDailyJob() {
		quit = false;
		this.thread.interrupt();
		System.out.println(">>> Daily job stopped");
	}

	public Thread getThread() {
		return thread;
	}
}
