package app.core.job;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import app.core.exceptions.CouponSystemException;
import app.core.repos.CouponRepo;

@Component
@Transactional
@Scope("singleton")
public class CouponExpirationDailyJob {// implements Runnable {

	@Autowired
	private CouponRepo couponRepo;

	@Scheduled(cron = " 0 0 * * * *")
	public void dailyJob() throws CouponSystemException {
		couponRepo.deleteByEndDateBefore(LocalDate.now());
		System.out.println("Daily job deleting coupons performed");
	}
//	private boolean quit;
//	private Thread thread = new Thread(this, "daily_job");
//
//	@Override
//	public void run(){
//		System.out.println(">>> Daily job running");
//		while(!quit) {
//			try {
//				TimeUnit.SECONDS.sleep(20);
//				couponRepo.deleteByEndDateBefore(LocalDate.now());
//				System.out.println(">>> All expired coupons deleted");
//				TimeUnit.DAYS.sleep(1);
//			} catch (InterruptedException | CouponSystemException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	/**
//	 * Start Daily Job Thread, boolean
//	 */
//	@PostConstruct
//	public void startDailyJob() {
//		quit = true;
//		this.thread.start();
//		System.out.println(">>> Daily job started");
//	}
//	
//	/**
//	 * Stop Daily Job Thread, boolean
//	 */
//	@PreDestroy
//	public void stopDailyJob() {
//		quit = false;
//		this.thread.interrupt();
//		System.out.println(">>> Daily job stopped");
//	}
//
//	public Thread getThread() {
//		return thread;
//	}
}
