package app.core.job;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import app.core.entities.Coupon;
import app.core.repos.CouponRepo;

@Component
@Transactional
@Scope("singleton")
public class CouponExpirationDailyJob implements Runnable {

	@Autowired
	private CouponRepo couponRepo;
	private boolean quit;
	private Thread thread = new Thread(this, "daily_job");

	@Override
	public void run(){
		System.out.println(">>> Daily job running");
		while(!quit) {
			try {
				TimeUnit.SECONDS.sleep(20);
				List<Coupon> coupons = couponRepo.findAll();
				for (Coupon coupon : coupons) {
					if(LocalDate.now().isAfter(coupon.getEndDate())) {
						couponRepo.delete(coupon);
					}
				}
				System.out.println(">>> All expired coupons deleted");
				TimeUnit.DAYS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Start Daily Job Thread, boolean
	 */
	@PostConstruct
	public void startDailyJob() {
		quit = true;
		this.thread.start();
		System.out.println(">>> Daily job started");
	}
	
	/**
	 * Stop Daily Job Thread, boolean
	 */
	@PreDestroy
	public void stopDailyJob() {
		quit = false;
		this.thread.interrupt();
		System.out.println(">>> Daily job stopped");
	}

	public Thread getThread() {
		return thread;
	}
}
